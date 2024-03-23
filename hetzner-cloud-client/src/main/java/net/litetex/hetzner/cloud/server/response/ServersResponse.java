package net.litetex.hetzner.cloud.server.response;

import java.util.List;

import net.litetex.hetzner.cloud.list.response.ListResponse;
import net.litetex.hetzner.cloud.shared.Meta;


public record ServersResponse(
	List<Server> servers,
	Meta meta
) implements ListResponse<Server>
{
	@Override
	public List<Server> data()
	{
		return this.servers();
	}
}
