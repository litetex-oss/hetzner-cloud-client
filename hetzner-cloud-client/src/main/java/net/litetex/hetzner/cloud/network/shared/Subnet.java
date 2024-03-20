package net.litetex.hetzner.cloud.network.shared;

import java.util.Objects;

import jakarta.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.IBuilder;


public record Subnet(
    @Nonnull
    @JsonProperty("type")
    String subnetType,
    @JsonProperty("ip_range")
    String ipRange,
    @Nonnull
    @JsonProperty("network_zone")
    String networkZone,
    String gateway
)
{
    public Subnet
    {
        Objects.requireNonNull(subnetType);
        Objects.requireNonNull(networkZone);
    }
    
    public static class Builder implements IBuilder<Subnet>
    {
        private String subnetType;
        private String ipRange;
        private String networkZone;
        private String gateway;
        
        public Builder subnetType(final String subnetType)
        {
            this.subnetType = subnetType;
            return this;
        }
        
        public Builder ipRange(final String ipRange)
        {
            this.ipRange = ipRange;
            return this;
        }
        
        public Builder networkZone(final String networkZone)
        {
            this.networkZone = networkZone;
            return this;
        }
        
        public Builder gateway(final String gateway)
        {
            this.gateway = gateway;
            return this;
        }
        
        @Override
        public Subnet build()
        {
            return new Subnet(this.subnetType, this.ipRange, this.networkZone, this.gateway);
        }
    }
}
