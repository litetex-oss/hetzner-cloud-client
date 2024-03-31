package net.litetex.hetzner.cloud.certificate;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UncheckedIOException;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.SubjectKeyIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.cert.X509ExtensionUtils;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.bc.BcDigestCalculatorProvider;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.junit.jupiter.api.Assertions;

import net.litetex.hetzner.cloud.CRUDTest;
import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.certificate.response.Certificate;
import net.litetex.hetzner.cloud.certificate.response.CreateCertificateResponse;


@SuppressWarnings("java:S2187") // Test are in parent
class CertificatesTest extends CRUDTest<CertificatesAPI, Certificate>
{
	private static final String KEY_ID = "test";
	
	public CertificatesTest()
	{
		super(HetznerCloudAPI::certificates);
	}
	
	@Override
	protected Certificate create()
	{
		try
		{
			final KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(4096);
			final KeyPair keyPair = keyPairGenerator.generateKeyPair();
			final X509Certificate certificate = this.generateCertificate(keyPair, "SHA256withRSA", "test.example.com");
			
			final String privateKey = String.format(
				"-----BEGIN PRIVATE KEY-----\n%s\n-----END PRIVATE KEY-----",
				Base64.getMimeEncoder(64, System.lineSeparator().getBytes())
					.encodeToString(keyPair.getPrivate().getEncoded()));
			final String publicKey = this.convertCertificateToPem(certificate);
			
			final CreateCertificateResponse createCertificateResponse = this.api.create(b -> b
				.name(KEY_ID)
				.privateKey(privateKey)
				.certificate(publicKey)
				.build());
			
			final long certId = createCertificateResponse.certificate().id();
			Assertions.assertNotNull(createCertificateResponse.certificate());
			Assertions.assertTrue(certId > 0);
			
			return createCertificateResponse.certificate();
		}
		catch(final NoSuchAlgorithmException | OperatorCreationException | CertificateException | CertIOException e)
		{
			throw new IllegalStateException(e);
		}
	}
	
	@Override
	protected void update(final Certificate created)
	{
		this.api.update(created.id(), b -> b.label("x", "y"));
	}
	
	@Override
	protected List<Certificate> list()
	{
		final List<Certificate> allCertificates = super.list();
		Assertions.assertEquals(1, allCertificates.size());
		return allCertificates;
	}
	
	@Override
	protected Certificate get(final Long id)
	{
		final Certificate certificate = super.get(id);
		Assertions.assertEquals(KEY_ID, certificate.name());
		Assertions.assertEquals("y", certificate.labels().get("x"));
		return certificate;
	}
	
	private X509Certificate generateCertificate(final KeyPair keyPair, final String hashAlgorithm, final String cn)
		throws OperatorCreationException, CertificateException, CertIOException
	{
		final Date notBefore = java.sql.Timestamp.valueOf(LocalDateTime.now());
		final Date notAfter = java.sql.Timestamp.valueOf(LocalDateTime.now().plusYears(2));
		final ContentSigner contentSigner = new JcaContentSignerBuilder(hashAlgorithm).build(keyPair.getPrivate());
		final X500Name x500CN = new X500Name("CN=" + cn);
		final X509v3CertificateBuilder certificateBuilder =
			new JcaX509v3CertificateBuilder(
				x500CN,
				BigInteger.valueOf(System.currentTimeMillis()),
				notBefore,
				notAfter,
				x500CN,
				keyPair.getPublic())
				.addExtension(Extension.subjectKeyIdentifier, false, this.createSubjectKeyId(keyPair.getPublic()))
				.addExtension(
					Extension.authorityKeyIdentifier,
					false,
					this.createAuthorityKeyId(keyPair.getPublic()))
				.addExtension(Extension.basicConstraints, true, new BasicConstraints(true));
		return new JcaX509CertificateConverter()
			.setProvider(new BouncyCastleProvider()).getCertificate(certificateBuilder.build(contentSigner));
	}
	
	private SubjectKeyIdentifier createSubjectKeyId(final PublicKey publicKey) throws OperatorCreationException
	{
		final SubjectPublicKeyInfo publicKeyInfo = SubjectPublicKeyInfo.getInstance(publicKey.getEncoded());
		final DigestCalculator digCalc =
			new BcDigestCalculatorProvider().get(new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1));
		
		return new X509ExtensionUtils(digCalc).createSubjectKeyIdentifier(publicKeyInfo);
	}
	
	private AuthorityKeyIdentifier createAuthorityKeyId(final PublicKey publicKey) throws OperatorCreationException
	{
		final SubjectPublicKeyInfo publicKeyInfo = SubjectPublicKeyInfo.getInstance(publicKey.getEncoded());
		final DigestCalculator digCalc =
			new BcDigestCalculatorProvider().get(new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1));
		
		return new X509ExtensionUtils(digCalc).createAuthorityKeyIdentifier(publicKeyInfo);
	}
	
	private String convertCertificateToPem(final X509Certificate cert)
	{
		final StringWriter writer = new StringWriter();
		try(final JcaPEMWriter pemWriter = new JcaPEMWriter(writer))
		{
			pemWriter.writeObject(cert);
			pemWriter.flush();
		}
		catch(final IOException e)
		{
			throw new UncheckedIOException(e);
		}
		return writer.toString();
	}
}
