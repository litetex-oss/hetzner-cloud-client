package net.litetex.hetzner.cloud.volume.response;

import java.time.OffsetDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.location.response.Location;
import net.litetex.hetzner.cloud.protection.response.Protection;
import net.litetex.hetzner.cloud.support.HasID;


public record Volume(
    long id,
    OffsetDateTime created,
    String name,
    Long server,
    Location location,
    Long size,
    @JsonProperty("linux_device")
    String linuxDevice,
    Protection protection,
    Map<String, String> labels,
    String status,
    String format
) implements HasID
{
}
