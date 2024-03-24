package net.litetex.hetzner.cloud.primaryip.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.actions.response.Action;
import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record CreatePrimaryIPResponse(
    Action action,
    @JsonProperty("primary_ip")
    PrimaryIP primaryIP
) implements SingleResponse<PrimaryIP>
{
    @Override
    public PrimaryIP data()
    {
        return this.primaryIP();
    }
}
