package net.litetex.hetzner.cloud.datacenter.response;

import java.util.List;

import net.litetex.hetzner.cloud.shared.Meta;


public record DatacentersResponse(
	List<Datacenter> datacenters,
	Meta meta,
	long recommendation)
{
}
