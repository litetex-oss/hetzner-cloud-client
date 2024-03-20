package net.litetex.hetzner.cloud.primaryip.response;

import com.fasterxml.jackson.annotation.JsonProperty;


public record PrimaryIPResponse(
    @JsonProperty("primary_ip")
    PrimaryIP primaryIP)
{
}
