package net.litetex.hetzner.cloud.loadbalancer.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record LoadBalancerResponse(
    @JsonProperty("load_balancer")
    LoadBalancer loadBalancer
) implements SingleResponse<LoadBalancer>
{
    @Override
    public LoadBalancer data()
    {
        return this.loadBalancer();
    }
}
