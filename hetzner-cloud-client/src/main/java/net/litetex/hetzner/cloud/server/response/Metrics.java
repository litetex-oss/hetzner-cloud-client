package net.litetex.hetzner.cloud.server.response;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import net.litetex.hetzner.cloud.server.serialize.MetricsSerializer;


public record Metrics(
    OffsetDateTime start,
    OffsetDateTime end,
    Long step,
    @JsonProperty("time_series")
    @JsonSerialize(using = MetricsSerializer.class)
    Object timeSeries
)
{
}
