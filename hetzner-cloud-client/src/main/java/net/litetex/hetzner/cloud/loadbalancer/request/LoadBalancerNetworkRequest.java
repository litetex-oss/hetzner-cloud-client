package net.litetex.hetzner.cloud.loadbalancer.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.IBuilder;


public record LoadBalancerNetworkRequest(
    @JsonProperty("network")
    long network,
    @JsonProperty("ip")
    String ip
)
{
    public LoadBalancerNetworkRequest(final long network)
    {
        this(network, null);
    }
    
    public static class Builder implements IBuilder<LoadBalancerNetworkRequest>
    {
        private long network;
        private String ip;
        
        public Builder network(final long network)
        {
            this.network = network;
            return this;
        }
        
        public Builder ip(final String ip)
        {
            this.ip = ip;
            return this;
        }
        
        @Override
        public LoadBalancerNetworkRequest build()
        {
            return new LoadBalancerNetworkRequest(this.network, this.ip);
        }
    }
}
