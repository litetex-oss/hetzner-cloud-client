package net.litetex.hetzner.cloud.iso.response;

import java.util.List;

import net.litetex.hetzner.cloud.shared.Meta;


public record ISOsResponse(
	List<ISO> isos,
	Meta meta
)
{
}
