package net.litetex.hetzner.cloud.location.response;

import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record LocationResponse(
	Location location
) implements SingleResponse<Location>
{
	@Override
	public Location data()
	{
		return this.location();
	}
}
