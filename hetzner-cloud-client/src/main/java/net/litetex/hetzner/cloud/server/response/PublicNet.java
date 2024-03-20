package net.litetex.hetzner.cloud.server.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.shared.DnsPTR;


public record PublicNet(
    IPv4 ipv4,
    IPv6 ipv6,
    @JsonProperty("floating_ips")
    List<Long> floatingIPs)
{
    public record IPv4(
        Long id,
        String ip,
        boolean blocked,
        @JsonProperty("dns_ptr")
        String dnsPTR)
    {
    }
    
    
    public record IPv6(
        Long id,
        String ip,
        boolean blocked,
        @JsonProperty("dns_ptr")
        List<DnsPTR> dnsPTR)
    {
    }
}
