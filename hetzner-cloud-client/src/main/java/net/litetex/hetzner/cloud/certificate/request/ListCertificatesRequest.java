package net.litetex.hetzner.cloud.certificate.request;

import net.litetex.hetzner.cloud.RelativeUrlBuilder;
import net.litetex.hetzner.cloud.list.request.ListRequest;


public class ListCertificatesRequest extends ListRequest<ListCertificatesRequest>
{
	protected String type;
	
	public ListCertificatesRequest type(final String type)
	{
		this.type = type;
		return this.self();
	}
	
	@Override
	public RelativeUrlBuilder applyTo(final RelativeUrlBuilder relativeUrlBuilder)
	{
		return super.applyTo(relativeUrlBuilder)
			.queryParam("type", this.type);
	}
}
