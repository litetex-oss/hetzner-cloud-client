package net.litetex.hetzner.cloud.error.response;

import java.util.List;


public record APIErrorDetails(List<Field> fields)
{
	public record Field(
		String name,
		String[] messages)
	{
	}
}
