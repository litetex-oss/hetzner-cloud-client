package net.litetex.hetzner.cloud.network.request;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.NameLabelsBuilder;


public record UpdateNetworkRequest(
    String name,
    Map<String, String> labels,
    @JsonProperty("expose_routes_to_vswitch")
    Boolean exposeRoutesToVswitch
)
{
    public static class Builder extends NameLabelsBuilder<Builder, UpdateNetworkRequest>
    {
        private Boolean exposeRoutesToVswitch;
        
        public Builder exposeRoutesToVswitch(final Boolean exposeRoutesToVswitch)
        {
            this.exposeRoutesToVswitch = exposeRoutesToVswitch;
            return this;
        }
        
        @Override
        public UpdateNetworkRequest build()
        {
            return new UpdateNetworkRequest(this.name, this.labels, this.exposeRoutesToVswitch);
        }
    }
}
