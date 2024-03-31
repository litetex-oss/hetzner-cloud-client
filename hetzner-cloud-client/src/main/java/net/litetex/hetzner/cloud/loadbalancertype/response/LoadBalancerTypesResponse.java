package net.litetex.hetzner.cloud.loadbalancertype.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.list.response.ListResponse;


public record LoadBalancerTypesResponse(
    @JsonProperty("load_balancer_types")
    List<LoadBalancerType> loadBalancerTypes
) implements ListResponse<LoadBalancerType>
{
    @Override
    public List<LoadBalancerType> data()
    {
        return this.loadBalancerTypes();
    }
}
