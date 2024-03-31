package net.litetex.hetzner.cloud.certificate;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.actions.response.ActionResponse;
import net.litetex.hetzner.cloud.certificate.request.CreateCertificateRequest;
import net.litetex.hetzner.cloud.certificate.request.ListCertificatesRequest;
import net.litetex.hetzner.cloud.certificate.response.Certificate;
import net.litetex.hetzner.cloud.certificate.response.CertificateResponse;
import net.litetex.hetzner.cloud.certificate.response.CertificatesResponse;
import net.litetex.hetzner.cloud.certificate.response.CreateCertificateResponse;
import net.litetex.hetzner.cloud.support.NameLabelsRequest;
import net.litetex.hetzner.cloud.support.api.NestedCRUDAPI;


public class CertificatesAPI
	extends NestedCRUDAPI<CertificatesResponse, Certificate, ListCertificatesRequest,
	CertificateResponse,
	CreateCertificateResponse, CreateCertificateRequest, CreateCertificateRequest.Builder,
	NameLabelsRequest, NameLabelsRequest.Builder>
{
	public CertificatesAPI(final HetznerCloudAPI parentAPI)
	{
		super(
			parentAPI,
			"/certificates",
			CertificatesResponse.class,
			ListCertificatesRequest::new,
			CertificateResponse.class,
			CreateCertificateResponse.class,
			CreateCertificateRequest.class,
			CreateCertificateRequest.Builder::new,
			NameLabelsRequest.class,
			NameLabelsRequest.Builder::new);
	}
	
	public ActionResponse retryCertificate(final long id)
	{
		return this.post("/" + id + "/actions/retry", ActionResponse.class);
	}
}
