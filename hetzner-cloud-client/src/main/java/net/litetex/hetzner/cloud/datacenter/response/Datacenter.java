package net.litetex.hetzner.cloud.datacenter.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.location.response.Location;


public record Datacenter(
	long id,
	String name,
	String description,
	Location location,
	@JsonProperty("server_types")
	ServerTypes serverTypes
)
{
	public record ServerTypes(
		List<Long> supported,
		List<Long> available,
		@JsonProperty("available_for_migration")
		List<Long> availableForMigration
	)
	{
	}
}
