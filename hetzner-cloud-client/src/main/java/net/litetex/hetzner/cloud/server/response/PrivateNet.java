package net.litetex.hetzner.cloud.server.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public record PrivateNet(
    Long network,
    String ip,
    @JsonProperty("alias_ip")
    List<String> aliasIps,
    @JsonProperty("mac_address")
    String macAddress
)
{
}
