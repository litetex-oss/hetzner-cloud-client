package net.litetex.hetzner.cloud.placementgroup.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.actions.response.Action;
import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record CreatePlacementGroupResponse(
	Action action,
	@JsonProperty("placement_group")
	PlacementGroup placementGroup
) implements SingleResponse<PlacementGroup>
{
	@Override
	public PlacementGroup data()
	{
		return this.placementGroup();
	}
}
