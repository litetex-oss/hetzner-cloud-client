package net.litetex.hetzner.cloud.primaryip.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.shared.Meta;


public record PrimaryIPsResponse(
    @JsonProperty("primary_ips")
    List<PrimaryIP> primaryIPs,
    Meta meta)
{
}
