package net.litetex.hetzner.cloud.loadbalancertype.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record LoadBalancerTypeResponse(
    @JsonProperty("load_balancer_type")
    LoadBalancerType loadBalancerType
) implements SingleResponse<LoadBalancerType>
{
    @Override
    public LoadBalancerType data()
    {
        return this.loadBalancerType();
    }
}
