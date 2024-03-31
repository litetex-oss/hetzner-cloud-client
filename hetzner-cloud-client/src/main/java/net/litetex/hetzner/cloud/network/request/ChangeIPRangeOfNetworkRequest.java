package net.litetex.hetzner.cloud.network.request;

import java.util.Objects;

import jakarta.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonProperty;


public record ChangeIPRangeOfNetworkRequest(
    @Nonnull
    @JsonProperty("ip_range")
    String ipRange
)
{
    public ChangeIPRangeOfNetworkRequest
    {
        Objects.requireNonNull(ipRange);
    }
}

