package net.litetex.hetzner.cloud.server.request;

import net.litetex.hetzner.cloud.RelativeUrlBuilder;
import net.litetex.hetzner.cloud.list.request.ListRequest;


public class ListServersRequest extends ListRequest<ListServersRequest>
{
	protected String status;
	
	public ListServersRequest status(final String status)
	{
		this.status = status;
		return this.self();
	}
	
	@Override
	public RelativeUrlBuilder applyTo(final RelativeUrlBuilder relativeUrlBuilder)
	{
		return super.applyTo(relativeUrlBuilder)
			.queryParam("status", this.status);
	}
}
