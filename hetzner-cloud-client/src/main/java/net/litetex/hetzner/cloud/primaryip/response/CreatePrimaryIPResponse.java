package net.litetex.hetzner.cloud.primaryip.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.actions.response.Action;


public record CreatePrimaryIPResponse(
    Action action,
    @JsonProperty("primary_ip")
    PrimaryIP primaryIP)
{
}
