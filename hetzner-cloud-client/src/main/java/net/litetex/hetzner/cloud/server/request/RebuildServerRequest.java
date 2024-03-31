package net.litetex.hetzner.cloud.server.request;

import java.util.Objects;

import jakarta.annotation.Nonnull;


public record RebuildServerRequest(
	@Nonnull
    String image
)
{
	public RebuildServerRequest
	{
		Objects.requireNonNull(image);
	}
}
