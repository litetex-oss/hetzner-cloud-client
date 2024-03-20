package net.litetex.hetzner.cloud.firewall.response;

import java.util.List;

import net.litetex.hetzner.cloud.shared.Meta;


public record FirewallsResponse(
	List<Firewall> firewalls,
	Meta meta
)
{
}
