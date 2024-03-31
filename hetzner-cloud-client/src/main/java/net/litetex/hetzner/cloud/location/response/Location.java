package net.litetex.hetzner.cloud.location.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.HasID;


public record Location(
	long id,
	String name,
	String description,
	String country,
	String city,
	Double latitude,
	Double longitude,
	@JsonProperty("network_zone")
	String networkZone
) implements HasID
{
}
