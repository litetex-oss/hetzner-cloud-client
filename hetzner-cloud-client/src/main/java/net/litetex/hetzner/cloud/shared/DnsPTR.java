package net.litetex.hetzner.cloud.shared;

import com.fasterxml.jackson.annotation.JsonProperty;


public record DnsPTR(
    @JsonProperty("dns_ptr")
    String dnsPTR,
    String ip)
{
}
