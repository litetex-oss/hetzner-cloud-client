package net.litetex.hetzner.cloud.image.response;

import java.time.OffsetDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.protection.response.Protection;


public record Image(
    Long id,
    String type,
    String status,
    String name,
    String description,
    @JsonProperty("image_size")
    Double imageSize,
    @JsonProperty("disk_size")
    Double diskSize,
    OffsetDateTime created,
    OffsetDateTime deleted,
    @JsonProperty("created_from")
    CreatedFrom createdFrom,
    @JsonProperty("bound_to")
    Long boundTo,
    @JsonProperty("os_flavor")
    String osFlavor,
    @JsonProperty("os_version")
    String osVersion,
    @JsonProperty("rapid_redeploy")
    boolean rapidRedeploy,
    OffsetDateTime deprecated,
    Protection protection,
    Map<String, String> labels,
    String architecture)
{
    public record CreatedFrom(
        Long id,
        String name
    )
    {
    }
}
