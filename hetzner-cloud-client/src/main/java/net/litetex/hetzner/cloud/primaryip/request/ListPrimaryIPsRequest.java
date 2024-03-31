package net.litetex.hetzner.cloud.primaryip.request;

import net.litetex.hetzner.cloud.RelativeUrlBuilder;
import net.litetex.hetzner.cloud.list.request.ListRequest;


public class ListPrimaryIPsRequest extends ListRequest<ListPrimaryIPsRequest>
{
	protected String ip;
	
	public ListPrimaryIPsRequest ip(final String ip)
	{
		this.ip = ip;
		return this.self();
	}
	
	@Override
	public RelativeUrlBuilder applyTo(final RelativeUrlBuilder relativeUrlBuilder)
	{
		return super.applyTo(relativeUrlBuilder)
			.queryParam("ip", this.ip);
	}
}
