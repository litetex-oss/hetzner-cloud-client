package net.litetex.hetzner.cloud.network.request;

import java.util.Objects;

import jakarta.annotation.Nonnull;

import net.litetex.hetzner.cloud.support.IBuilder;


public record NetworkRouteRequest(
    @Nonnull
    String destination,
    @Nonnull
    String gateway
)
{
    public NetworkRouteRequest
    {
        Objects.requireNonNull(destination);
        Objects.requireNonNull(gateway);
    }
    
    public static class Builder implements IBuilder<NetworkRouteRequest>
    {
        private String destination;
        private String gateway;
        
        public Builder destination(final String destination)
        {
            this.destination = destination;
            return this;
        }
        
        public Builder gateway(final String gateway)
        {
            this.gateway = gateway;
            return this;
        }
        
        @Override
        public NetworkRouteRequest build()
        {
            return new NetworkRouteRequest(this.destination, this.gateway);
        }
    }
}
