package net.litetex.hetzner.cloud.firewall.response;

import java.util.List;

import net.litetex.hetzner.cloud.actions.response.Action;


public record CreateFirewallResponse(
	List<Action> actions,
	Firewall firewall
)
{
}
