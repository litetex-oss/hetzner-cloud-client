package net.litetex.hetzner.cloud.certificate.request;

import java.util.ArrayList;
import java.util.List;

import net.litetex.hetzner.cloud.RelativeUrlBuilder;
import net.litetex.hetzner.cloud.list.request.ListRequest;


public class ListCertificatesRequest extends ListRequest<ListCertificatesRequest>
{
	protected List<String> type = new ArrayList<>();
	
	public ListCertificatesRequest type(final String type)
	{
		this.type.add(type);
		return this.self();
	}
	
	@Override
	public RelativeUrlBuilder applyTo(final RelativeUrlBuilder relativeUrlBuilder)
	{
		return super.applyTo(relativeUrlBuilder)
			.queryParams("type", this.type);
	}
}
