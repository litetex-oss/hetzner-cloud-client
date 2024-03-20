package net.litetex.hetzner.cloud.floatingip.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.actions.response.Action;


public record CreateFloatingIPResponse(
    @JsonProperty("floating_ip")
    FloatingIP floatingIP,
    Action action
)
{
}
