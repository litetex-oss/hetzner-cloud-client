package net.litetex.hetzner.cloud.loadbalancer.response;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.loadbalancer.shared.LBAlgorithm;
import net.litetex.hetzner.cloud.loadbalancer.shared.service.LBService;
import net.litetex.hetzner.cloud.loadbalancer.shared.target.LBTarget;
import net.litetex.hetzner.cloud.loadbalancertype.response.LoadBalancerType;
import net.litetex.hetzner.cloud.location.response.Location;
import net.litetex.hetzner.cloud.protection.response.Protection;


public record LoadBalancer(
    long id,
    String name,
    LBAlgorithm algorithm,
    OffsetDateTime created,
    @JsonProperty("included_traffic")
    long includedTrafficBytes,
    @JsonProperty("ingoing_traffic")
    Long ingoingTraffic,
    @JsonProperty("outgoing_traffic")
    Long outgoingTraffic,
    Map<String, String> labels,
    @JsonProperty("load_balancer_type")
    LoadBalancerType loadBalancerType,
    Location location,
    @JsonProperty("private_net")
    List<LBPrivateNet> privateNet,
    Protection protection,
    @JsonProperty("public_net")
    LBPublicNet publicNet,
    List<LBService> services,
    List<LBTarget> targets
)
{
    
    public record LBPrivateNet(
        String ip,
        Long network)
    {
    }
    
    
    public record LBPublicNet(
        boolean enabled,
        LBPublicNetIPEntry ipv4,
        LBPublicNetIPEntry ipv6)
    {
        public record LBPublicNetIPEntry(
            @JsonProperty("dns_ptr")
            String dnsPtr,
            String ip
        )
        {
        }
    }
}
