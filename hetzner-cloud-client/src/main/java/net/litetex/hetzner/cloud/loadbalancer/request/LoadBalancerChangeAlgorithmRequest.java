package net.litetex.hetzner.cloud.loadbalancer.request;

import com.fasterxml.jackson.annotation.JsonProperty;


public record LoadBalancerChangeAlgorithmRequest(
    @JsonProperty("type")
    String type
)
{
}
