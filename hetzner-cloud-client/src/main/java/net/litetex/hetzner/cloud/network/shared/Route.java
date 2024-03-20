package net.litetex.hetzner.cloud.network.shared;

import java.util.Objects;

import jakarta.annotation.Nonnull;

import net.litetex.hetzner.cloud.support.IBuilder;


public record Route(
    @Nonnull
    String destination,
    @Nonnull
    String gateway
)
{
    public Route
    {
        Objects.requireNonNull(destination);
        Objects.requireNonNull(gateway);
    }
    
    public static class Builder implements IBuilder<Route>
    {
        private String destination;
        private String gateway;
        
        public Builder()
        {
        }
        
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
        public Route build()
        {
            return new Route(this.destination, this.gateway);
        }
    }
}
