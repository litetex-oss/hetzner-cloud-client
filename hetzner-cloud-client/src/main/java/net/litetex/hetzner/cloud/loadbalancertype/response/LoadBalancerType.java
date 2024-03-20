package net.litetex.hetzner.cloud.loadbalancertype.response;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.pricing.response.LocationPrice;


public record LoadBalancerType(
    long id,
    String name,
    String description,
    @JsonProperty("max_connections")
    long maxConnections,
    @JsonProperty("max_services")
    long maxServices,
    @JsonProperty("max_targets")
    long maxTargets,
    @JsonProperty("max_assigned_certificates")
    long maxAssignedCertificates,
    OffsetDateTime deprecated,
    List<LocationPrice> prices
)
{
}
