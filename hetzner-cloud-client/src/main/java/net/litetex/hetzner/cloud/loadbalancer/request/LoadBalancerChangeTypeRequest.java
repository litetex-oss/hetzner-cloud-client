package net.litetex.hetzner.cloud.loadbalancer.request;

import com.fasterxml.jackson.annotation.JsonProperty;


public record LoadBalancerChangeTypeRequest(
	@JsonProperty("load_balancer_type")
	String loadBalancerType
)
{
}
