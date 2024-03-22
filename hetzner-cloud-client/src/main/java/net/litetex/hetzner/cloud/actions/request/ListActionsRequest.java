package net.litetex.hetzner.cloud.actions.request;

import net.litetex.hetzner.cloud.RelativeUrlBuilder;
import net.litetex.hetzner.cloud.list.request.ListRequest;


public class ListActionsRequest extends ListRequest<ListActionsRequest>
{
	protected String status;
	
	public ListActionsRequest status(final String status)
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
