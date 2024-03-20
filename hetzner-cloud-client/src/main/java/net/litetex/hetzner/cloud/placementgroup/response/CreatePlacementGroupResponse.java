package net.litetex.hetzner.cloud.placementgroup.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.actions.response.Action;


public record CreatePlacementGroupResponse(
	Action action,
	@JsonProperty("placement_group")
	PlacementGroup placementGroup
)
{
}
