package net.litetex.hetzner.cloud.placementgroup.request;

import net.litetex.hetzner.cloud.RelativeUrlBuilder;
import net.litetex.hetzner.cloud.list.request.ListRequest;


public class ListPlacementGroupsRequest extends ListRequest<ListPlacementGroupsRequest>
{
	protected String type;
	
	public ListPlacementGroupsRequest type(final String type)
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
