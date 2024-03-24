package net.litetex.hetzner.cloud.datacenter.response;

import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record DatacenterResponse(
	Datacenter datacenter
) implements SingleResponse<Datacenter>
{
	@Override
	public Datacenter data()
	{
		return this.datacenter();
	}
}
