package net.litetex.hetzner.cloud.loadbalancer.request;

import com.fasterxml.jackson.annotation.JsonProperty;


public record LoadBalancerDeleteServiceRequest(
	@JsonProperty("listen_port")
	long listenPort
)
{
}
