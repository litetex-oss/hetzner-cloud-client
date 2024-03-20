package net.litetex.hetzner.cloud.loadbalancertype.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public record LoadBalancerTypesResponse(
    @JsonProperty("load_balancer_types")
    List<LoadBalancerType> loadBalancerTypes
)
{
}
