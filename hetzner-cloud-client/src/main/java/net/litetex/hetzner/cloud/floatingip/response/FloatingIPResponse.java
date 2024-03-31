package net.litetex.hetzner.cloud.floatingip.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record FloatingIPResponse(
    @JsonProperty("floating_ip")
    FloatingIP floatingIP
) implements SingleResponse<FloatingIP>
{
    @Override
    public FloatingIP data()
    {
        return this.floatingIP();
    }
}
