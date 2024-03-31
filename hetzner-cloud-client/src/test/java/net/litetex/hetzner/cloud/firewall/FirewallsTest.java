package net.litetex.hetzner.cloud.firewall;

import org.junit.jupiter.api.Assertions;

import net.litetex.hetzner.cloud.CRUDTest;
import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.firewall.response.Firewall;
import net.litetex.hetzner.cloud.firewall.shared.FirewallRule;


@SuppressWarnings("java:S2187") // Test are in parent
class FirewallsTest extends CRUDTest<FirewallsAPI, Firewall>
{
	public FirewallsTest()
	{
		super(HetznerCloudAPI::firewalls);
	}
	
	@Override
	protected Firewall create()
	{
		return this.api.create(b -> b.name("test")
				.firewallRule(r -> r
					.direction(FirewallRule.Direction.IN)
					.protocol(FirewallRule.Protocol.ICMP)
					.sourceIP("0.0.0.0/0")
					.sourceIP("::/0")))
			.firewall();
	}
	
	@Override
	protected void update(final Firewall created)
	{
		this.api.update(created.id(), b -> b.label("x", "y"));
	}
	
	@Override
	protected Firewall get(final Long id)
	{
		final Firewall firewall = super.get(id);
		Assertions.assertEquals("y", firewall.labels().get("x"));
		Assertions.assertEquals(1, firewall.firewallRules().size());
		return firewall;
	}
}
