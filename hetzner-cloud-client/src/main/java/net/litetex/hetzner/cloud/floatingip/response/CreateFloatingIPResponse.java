package net.litetex.hetzner.cloud.floatingip.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.actions.response.Action;
import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record CreateFloatingIPResponse(
    @JsonProperty("floating_ip")
    FloatingIP floatingIP,
    Action action
) implements SingleResponse<FloatingIP>
{
    @Override
    public FloatingIP data()
    {
        return this.floatingIP();
    }
}
