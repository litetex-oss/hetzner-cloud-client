package net.litetex.hetzner.cloud.iso.response;

import java.util.List;

import net.litetex.hetzner.cloud.list.response.ListResponse;
import net.litetex.hetzner.cloud.shared.Meta;


public record ISOsResponse(
	List<ISO> isos,
	Meta meta
) implements ListResponse<ISO>
{
	@Override
	public List<ISO> data()
	{
		return this.isos();
	}
}
