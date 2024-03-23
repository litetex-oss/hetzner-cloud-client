package net.litetex.hetzner.cloud.placementgroup.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.list.response.ListResponse;
import net.litetex.hetzner.cloud.shared.Meta;


public record PlacementGroupsResponse(
    @JsonProperty("placement_groups")
    List<PlacementGroup> placementGroups,
    Meta meta
) implements ListResponse<PlacementGroup>
{
    @Override
    public List<PlacementGroup> data()
    {
        return this.placementGroups();
    }
}
