package net.litetex.hetzner.cloud.volume.response;

import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record VolumeResponse(
	Volume volume
) implements SingleResponse<Volume>
{
	@Override
	public Volume data()
	{
		return this.volume();
	}
}
