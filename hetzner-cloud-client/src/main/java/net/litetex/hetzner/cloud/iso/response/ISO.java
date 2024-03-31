package net.litetex.hetzner.cloud.iso.response;

import net.litetex.hetzner.cloud.shared.Deprecation;
import net.litetex.hetzner.cloud.support.HasID;


public record ISO(
	long id,
    String name,
    String description,
    String type,
    String architecture,
    Deprecation deprecation
) implements HasID
{
}
