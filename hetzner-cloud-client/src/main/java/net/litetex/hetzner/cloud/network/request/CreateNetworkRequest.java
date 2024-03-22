package net.litetex.hetzner.cloud.network.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

import jakarta.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.network.shared.Route;
import net.litetex.hetzner.cloud.network.shared.Subnet;
import net.litetex.hetzner.cloud.support.BuilderUtil;
import net.litetex.hetzner.cloud.support.NameLabelsBuilder;


public record CreateNetworkRequest(
    @Nonnull
    String name,
    @Nonnull
    @JsonProperty("ip_range")
    String ipRange,
    List<Subnet> subnets,
    List<Route> routes,
    Map<String, String> labels,
    @JsonProperty("expose_routes_to_vswitch")
    Boolean exposeRoutesToVswitch)
{
    public CreateNetworkRequest
    {
        Objects.requireNonNull(name);
        Objects.requireNonNull(ipRange);
    }
    
    public static class Builder extends NameLabelsBuilder<Builder, CreateNetworkRequest>
    {
        private String ipRange;
        private List<Subnet> subnets;
        private List<Route> routes;
        private Boolean exposeRoutesToVswitch;
        
        public Builder ipRange(final String ipRange)
        {
            this.ipRange = ipRange;
            return this;
        }
        
        public Builder subnets(final List<Subnet> subnets)
        {
            this.subnets = subnets;
            return this;
        }
        
        public Builder subnet(final Subnet subnet)
        {
            if(this.subnets == null)
            {
                this.subnets = new ArrayList<>();
            }
            this.subnets.add(subnet);
            return this;
        }
        
        public Builder subnet(final Consumer<Subnet.Builder> builderConsumer)
        {
            return this.subnet(BuilderUtil.build(Subnet.Builder::new, builderConsumer));
        }
        
        public Builder routes(final List<Route> routes)
        {
            this.routes = routes;
            return this;
        }
        
        public Builder route(final Route route)
        {
            if(this.routes == null)
            {
                this.routes = new ArrayList<>();
            }
            this.routes.add(route);
            return this;
        }
        
        public Builder route(final Consumer<Route.Builder> builderConsumer)
        {
            return this.route(BuilderUtil.build(Route.Builder::new, builderConsumer));
        }
        
        public Builder exposeRoutesToVswitch(final Boolean exposeRoutesToVswitch)
        {
            this.exposeRoutesToVswitch = exposeRoutesToVswitch;
            return this;
        }
        
        @Override
        public CreateNetworkRequest build()
        {
            return new CreateNetworkRequest(this.name, this.ipRange, this.subnets,
                this.routes, this.labels, this.exposeRoutesToVswitch);
        }
    }
}
