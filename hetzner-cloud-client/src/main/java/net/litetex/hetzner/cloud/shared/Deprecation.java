package net.litetex.hetzner.cloud.shared;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;


public record Deprecation(
    OffsetDateTime announced,
    @JsonProperty("unavailable_after")
    OffsetDateTime unavailableAfter
)
{
}
