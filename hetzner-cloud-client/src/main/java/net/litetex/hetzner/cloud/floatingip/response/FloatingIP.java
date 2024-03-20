package net.litetex.hetzner.cloud.floatingip.response;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.location.response.Location;
import net.litetex.hetzner.cloud.protection.response.Protection;
import net.litetex.hetzner.cloud.shared.DnsPTR;


public record FloatingIP(
    Long id,
    String name,
    String description,
    String ip,
    @JsonProperty("type")
    String ipType,
    Long server,
    @JsonProperty("dns_ptr")
    List<DnsPTR> dnsPTR,
    @JsonProperty("home_location")
    Location homeLocation,
    Boolean blocked,
    Protection protection,
    Map<String, String> labels,
    OffsetDateTime created
)
{
}
