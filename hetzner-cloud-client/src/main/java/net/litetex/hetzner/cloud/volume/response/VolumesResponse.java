package net.litetex.hetzner.cloud.volume.response;

import java.util.List;

import net.litetex.hetzner.cloud.list.response.ListResponse;
import net.litetex.hetzner.cloud.shared.Meta;


public record VolumesResponse(
    List<Volume> volumes,
    Meta meta
) implements ListResponse<Volume>
{
	@Override
	public List<Volume> data()
	{
		return this.volumes();
	}
}
