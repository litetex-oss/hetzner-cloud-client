package net.litetex.hetzner.cloud.network.request;

import java.util.Objects;

import jakarta.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.IBuilder;


public record AddSubnetToNetworkRequest(
    @Nonnull
    String type,
    @JsonProperty("ip_range")
    String ipRange,
    @Nonnull
    @JsonProperty("network_zone")
    String networkZone,
    @JsonProperty("vswitch_id")
    Long vSwitchId
)
{
    public AddSubnetToNetworkRequest
    {
        Objects.requireNonNull(networkZone);
        Objects.requireNonNull(type);
    }
    
    public static class Builder implements IBuilder<AddSubnetToNetworkRequest>
    {
        private String type;
        private String ipRange;
        private String networkZone;
        private Long vSwitchId;
        
        public Builder type(final String type)
        {
            this.type = type;
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
        
        public Builder vSwitchId(final Long vSwitchId)
        {
            this.vSwitchId = vSwitchId;
            return this;
        }
        
        @Override
        public AddSubnetToNetworkRequest build()
        {
            return new AddSubnetToNetworkRequest(this.type, this.ipRange, this.networkZone, this.vSwitchId);
        }
    }
}
