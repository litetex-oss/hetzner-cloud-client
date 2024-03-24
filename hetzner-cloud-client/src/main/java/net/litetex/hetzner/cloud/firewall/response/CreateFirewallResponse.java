package net.litetex.hetzner.cloud.firewall.response;

import java.util.List;

import net.litetex.hetzner.cloud.actions.response.Action;
import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record CreateFirewallResponse(
	List<Action> actions,
	Firewall firewall
) implements SingleResponse<Firewall>
{
	@Override
	public Firewall data()
	{
		return this.firewall();
	}
}
