package net.litetex.hetzner.cloud.certificate;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UncheckedIOException;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.SubjectKeyIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509ExtensionUtils;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.bc.BcDigestCalculatorProvider;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.litetex.hetzner.cloud.APIRequestException;
import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.HetznerCloudTest;
import net.litetex.hetzner.cloud.certificate.response.Certificate;
import net.litetex.hetzner.cloud.certificate.response.CertificateResponse;
import net.litetex.hetzner.cloud.certificate.response.CreateCertificateResponse;


class CertificatesTest extends HetznerCloudTest<CertificatesAPI>
{
	public CertificatesTest()
	{
		super(HetznerCloudAPI::certificates);
	}
	
	@Test
	void check() throws Exception
	{
		final String keyId = UUID.randomUUID().toString();
		
		final KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(4096);
		final KeyPair keyPair = keyPairGenerator.generateKeyPair();
		final X509Certificate certificate;
		certificate = this.generateCertificate(keyPair, "SHA256withRSA", "test.example.com");
		
		final String privateKey = String.format(
			"-----BEGIN PRIVATE KEY-----\n%s\n-----END PRIVATE KEY-----",
			Base64.getMimeEncoder(64, System.lineSeparator().getBytes())
				.encodeToString(keyPair.getPrivate().getEncoded()));
		final String publicKey = this.convertCertificateToPem(certificate);
		
		final CreateCertificateResponse createCertificateResponse = this.api.create(b -> b
			.name(keyId)
			.privateKey(privateKey)
			.certificate(publicKey)
			.build());
		
		final long certId = createCertificateResponse.certificate().id();
		Assertions.assertNotNull(createCertificateResponse.certificate());
		Assertions.assertTrue(certId > 0);
		
		final List<Certificate> allCertificates = this.api.listAllData();
		Assertions.assertEquals(1, allCertificates.size());
		Assertions.assertEquals(certId, allCertificates.get(0).id());
		
		this.api.update(certId, b -> b.label("x", "y"));
		
		final CertificateResponse certificateResponse = this.api.get(certId);
		Assertions.assertEquals(keyId, certificateResponse.certificate().name());
		Assertions.assertEquals("y", certificateResponse.certificate().labels().get("x"));
		
		this.api.delete(certId);
		
		Assertions.assertThrows(APIRequestException.class, () -> this.api.get(certId));
	}
	
	@AfterEach
	void afterEach()
	{
		deleteAll(this.api);
	}
	
	private X509Certificate generateCertificate(final KeyPair keyPair, final String hashAlgorithm, final String cn)
		throws Exception
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
	
	private SubjectKeyIdentifier createSubjectKeyId(final PublicKey publicKey) throws Exception
	{
		final SubjectPublicKeyInfo publicKeyInfo = SubjectPublicKeyInfo.getInstance(publicKey.getEncoded());
		final DigestCalculator digCalc =
			new BcDigestCalculatorProvider().get(new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1));
		
		return new X509ExtensionUtils(digCalc).createSubjectKeyIdentifier(publicKeyInfo);
	}
	
	private AuthorityKeyIdentifier createAuthorityKeyId(final PublicKey publicKey) throws Exception
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
