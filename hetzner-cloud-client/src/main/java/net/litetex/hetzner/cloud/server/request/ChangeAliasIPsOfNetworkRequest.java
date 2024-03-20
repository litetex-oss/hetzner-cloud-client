package net.litetex.hetzner.cloud.server.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.IBuilder;


public record ChangeAliasIPsOfNetworkRequest(
    long network,
    @Nonnull
    @JsonProperty("alias_ips")
    List<String> aliasIps
)
{
    public ChangeAliasIPsOfNetworkRequest
    {
        Objects.requireNonNull(aliasIps);
    }
    
    public static class Builder implements IBuilder<ChangeAliasIPsOfNetworkRequest>
    {
        private long network;
        private List<String> aliasIps;
        
        public Builder network(final long network)
        {
            this.network = network;
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
        public ChangeAliasIPsOfNetworkRequest build()
        {
            return new ChangeAliasIPsOfNetworkRequest(this.network, this.aliasIps);
        }
    }
}
