package net.litetex.hetzner.cloud.placementgroup.response;

import com.fasterxml.jackson.annotation.JsonProperty;


public record PlacementGroupResponse(
    @JsonProperty("placement_group")
    PlacementGroup placementGroup
)
{
}
