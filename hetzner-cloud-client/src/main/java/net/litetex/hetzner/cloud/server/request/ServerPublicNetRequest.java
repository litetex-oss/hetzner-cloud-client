package net.litetex.hetzner.cloud.server.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.IBuilder;


public record ServerPublicNetRequest(
    @JsonProperty("enable_ipv4")
    Boolean enableIPv4,
    @JsonProperty("enable_ipv6")
    Boolean enableIPv6,
    Long ipv4,
    Long ipv6
)
{
    public static class Builder implements IBuilder<ServerPublicNetRequest>
    {
        private Boolean enableIPv4;
        private Boolean enableIPv6;
        private Long ipv4;
        private Long ipv6;
        
        public Builder enableIPv4(final Boolean enableIPv4)
        {
            this.enableIPv4 = enableIPv4;
            return this;
        }
        
        public Builder enableIPv6(final Boolean enableIPv6)
        {
            this.enableIPv6 = enableIPv6;
            return this;
        }
        
        public Builder ipv4(final Long ipv4)
        {
            this.ipv4 = ipv4;
            return this;
        }
        
        public Builder ipv6(final Long ipv6)
        {
            this.ipv6 = ipv6;
            return this;
        }
        
        @Override
        public ServerPublicNetRequest build()
        {
            return new ServerPublicNetRequest(this.enableIPv4, this.enableIPv6, this.ipv4, this.ipv6);
        }
    }
}
