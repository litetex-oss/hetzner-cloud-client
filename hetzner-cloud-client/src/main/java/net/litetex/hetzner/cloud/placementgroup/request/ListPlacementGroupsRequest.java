package net.litetex.hetzner.cloud.placementgroup.request;

import java.util.ArrayList;
import java.util.List;

import net.litetex.hetzner.cloud.RelativeUrlBuilder;
import net.litetex.hetzner.cloud.list.request.ListRequest;


public class ListPlacementGroupsRequest extends ListRequest<ListPlacementGroupsRequest>
{
	protected List<String> type = new ArrayList<>();
	
	public ListPlacementGroupsRequest type(final String type)
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
