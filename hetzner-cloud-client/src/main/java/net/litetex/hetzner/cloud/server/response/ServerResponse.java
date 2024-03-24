package net.litetex.hetzner.cloud.server.response;

import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record ServerResponse(
	Server server
) implements SingleResponse<Server>
{
	@Override
	public Server data()
	{
		return this.server();
	}
}
