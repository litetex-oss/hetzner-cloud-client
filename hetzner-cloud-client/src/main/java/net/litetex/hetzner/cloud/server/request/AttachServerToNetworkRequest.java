package net.litetex.hetzner.cloud.server.request;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.IBuilder;


public record AttachServerToNetworkRequest(
    long network,
    String ip,
    @JsonProperty("alias_ips")
    List<String> aliasIps
)
{
    public static class Builder implements IBuilder<AttachServerToNetworkRequest>
    {
        private long network;
        private String ip;
        private List<String> aliasIps;
        
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
        
        public Builder aliasIps(final List<String> aliasIps)
        {
            this.aliasIps = aliasIps;
            return this;
        }
        
        public Builder aliasIp(final String aliasIp)
        {
            if(this.aliasIps == null)
            {
                this.aliasIps = new ArrayList<>();
            }
            this.aliasIps.add(aliasIp);
            return this;
        }
        
        @Override
        public AttachServerToNetworkRequest build()
        {
            return new AttachServerToNetworkRequest(this.network, this.ip, this.aliasIps);
        }
    }
}
