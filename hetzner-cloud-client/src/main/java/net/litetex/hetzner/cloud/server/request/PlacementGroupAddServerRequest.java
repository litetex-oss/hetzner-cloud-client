package net.litetex.hetzner.cloud.server.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public record PlacementGroupAddServerRequest(
    @JsonProperty("placement_group")
    Long placementGroup)
{
}
