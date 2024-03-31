package net.litetex.hetzner.cloud.primaryip.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record PrimaryIPResponse(
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
