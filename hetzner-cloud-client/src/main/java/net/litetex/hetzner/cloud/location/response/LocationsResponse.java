package net.litetex.hetzner.cloud.location.response;

import java.util.List;

import net.litetex.hetzner.cloud.list.response.ListResponse;
import net.litetex.hetzner.cloud.shared.Meta;


public record LocationsResponse(
	List<Location> locations,
	Meta meta
) implements ListResponse<Location>
{
	@Override
	public List<Location> data()
	{
		return this.locations();
	}
}
