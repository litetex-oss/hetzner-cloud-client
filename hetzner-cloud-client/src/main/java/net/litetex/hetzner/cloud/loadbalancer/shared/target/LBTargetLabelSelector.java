package net.litetex.hetzner.cloud.loadbalancer.shared.target;

import java.util.Objects;

import jakarta.annotation.Nonnull;


public record LBTargetLabelSelector(
	@Nonnull
	String labelSelector)
{
	public LBTargetLabelSelector
	{
		Objects.requireNonNull(labelSelector);
	}
}
