package net.litetex.hetzner.cloud.placementgroup.response;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

import net.litetex.hetzner.cloud.support.HasID;


public record PlacementGroup(
	long id,
	String name,
	OffsetDateTime created,
	Map<String, String> labels,
	List<Long> servers,
	String type
) implements HasID
{
}
