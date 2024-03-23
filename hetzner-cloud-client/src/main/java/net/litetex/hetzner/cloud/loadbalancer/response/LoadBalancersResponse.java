package net.litetex.hetzner.cloud.loadbalancer.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.list.response.ListResponse;
import net.litetex.hetzner.cloud.shared.Meta;


public record LoadBalancersResponse(
    @JsonProperty("load_balancers")
    List<LoadBalancer> loadBalancers,
    Meta meta
) implements ListResponse<LoadBalancer>
{
    @Override
    public List<LoadBalancer> data()
    {
        return this.loadBalancers();
    }
}
