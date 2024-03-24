package net.litetex.hetzner.cloud.firewall.response;

import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record FirewallResponse(
	Firewall firewall
) implements SingleResponse<Firewall>
{
	@Override
	public Firewall data()
	{
		return this.firewall();
	}
}
