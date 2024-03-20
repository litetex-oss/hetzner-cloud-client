package net.litetex.hetzner.cloud.location.response;

import com.fasterxml.jackson.annotation.JsonProperty;


public record Location(
	Long id,
	String name,
	String description,
	String country,
	String city,
	Double latitude,
	Double longitude,
	@JsonProperty("network_zone")
	String networkZone
)
{
}
