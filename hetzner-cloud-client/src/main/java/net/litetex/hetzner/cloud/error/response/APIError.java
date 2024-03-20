package net.litetex.hetzner.cloud.error.response;

public record APIError(
	String code,
	String message,
	APIErrorDetails details)
{
}
