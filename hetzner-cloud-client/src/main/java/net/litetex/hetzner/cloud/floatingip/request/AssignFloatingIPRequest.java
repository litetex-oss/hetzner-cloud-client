package net.litetex.hetzner.cloud.floatingip.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AssignFloatingIPRequest(
    @JsonProperty("server")
    long serverId
)
{
}
