package net.litetex.hetzner.cloud.placementgroup.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record PlacementGroupResponse(
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
