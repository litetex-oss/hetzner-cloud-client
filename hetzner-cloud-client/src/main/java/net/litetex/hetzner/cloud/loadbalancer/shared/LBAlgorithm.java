package net.litetex.hetzner.cloud.loadbalancer.shared;

import java.util.Objects;

import jakarta.annotation.Nonnull;


public record LBAlgorithm(
	@Nonnull
	String type)
{
	public LBAlgorithm
	{
		Objects.requireNonNull(type);
	}
}
