package net.litetex.hetzner.cloud.loadbalancer.shared.target;

import java.util.Objects;

import jakarta.annotation.Nonnull;


public record LBTargetIP(
	@Nonnull
	String ip)
{
	public LBTargetIP
	{
		Objects.requireNonNull(ip);
	}
}
