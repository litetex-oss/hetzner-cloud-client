package net.litetex.hetzner.cloud.datacenter.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.location.response.Location;
import net.litetex.hetzner.cloud.support.HasID;


public record Datacenter(
	long id,
	String name,
	String description,
	Location location,
	@JsonProperty("server_types")
	ServerTypes serverTypes
) implements HasID
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
