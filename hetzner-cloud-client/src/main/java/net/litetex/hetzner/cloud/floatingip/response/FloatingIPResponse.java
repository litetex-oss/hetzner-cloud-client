package net.litetex.hetzner.cloud.floatingip.response;

import com.fasterxml.jackson.annotation.JsonProperty;


public record FloatingIPResponse(
    @JsonProperty("floating_ip")
    FloatingIP floatingIP
)
{
}
