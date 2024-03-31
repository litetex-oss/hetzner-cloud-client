package net.litetex.hetzner.cloud.network.response;

import java.util.List;

import net.litetex.hetzner.cloud.list.response.ListResponse;
import net.litetex.hetzner.cloud.shared.Meta;


public record NetworksResponse(
    List<Network> networks,
	Meta meta
) implements ListResponse<Network>
{
	@Override
	public List<Network> data()
	{
		return this.networks();
	}
}
