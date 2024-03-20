package net.litetex.hetzner.cloud.loadbalancertype.response;

import com.fasterxml.jackson.annotation.JsonProperty;


public record LoadBalancerTypeResponse(
    @JsonProperty("load_balancer_type")
    LoadBalancerType loadBalancerType
)
{
}
