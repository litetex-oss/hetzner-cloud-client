package net.litetex.hetzner.cloud.loadbalancer.response;

import com.fasterxml.jackson.annotation.JsonProperty;


public record LoadBalancerResponse(
    @JsonProperty("load_balancer")
    LoadBalancer loadBalancer
)
{
}
