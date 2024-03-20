package net.litetex.hetzner.cloud.volume.request;

import com.fasterxml.jackson.annotation.JsonProperty;


public record ResizeVolumeRequest(
	@JsonProperty("size")
	long sizeInGB
)
{
}
