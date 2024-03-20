package net.litetex.hetzner.cloud.network.response;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.network.shared.Route;
import net.litetex.hetzner.cloud.network.shared.Subnet;
import net.litetex.hetzner.cloud.protection.response.Protection;


public record Network(
    Long id,
    String name,
    @JsonProperty("ip_range")
    String ipRange,
    List<Subnet> subnets,
    List<Route> routes,
    List<Long> servers,
    @JsonProperty("load_balancers")
    List<Long> loadBalancers,
    Protection protection,
    Map<String, String> labels,
    OffsetDateTime created,
    @JsonProperty("expose_routes_to_vswitch")
    Boolean exposeRoutesToVswitch)
{
    
}
