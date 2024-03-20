package net.litetex.hetzner.cloud.loadbalancer.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.actions.response.Action;


public record CreateLoadBalancerResponse(
	Action action,
	@JsonProperty("load_balancer")
	LoadBalancer loadBalancer
)
{
}
