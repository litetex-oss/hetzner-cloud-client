package net.litetex.hetzner.cloud.network.response;

import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record NetworkResponse(
	Network network
) implements SingleResponse<Network>
{
	@Override
	public Network data()
	{
		return this.network();
	}
}
