package net.litetex.hetzner.cloud.iso.response;

import net.litetex.hetzner.cloud.shared.Deprecation;
import net.litetex.hetzner.cloud.shared.Meta;


public record ISO(
    Long id,
    String name,
    String description,
    String type,
    Meta meta,
    String architecture,
    Deprecation deprecation
)
{
}
