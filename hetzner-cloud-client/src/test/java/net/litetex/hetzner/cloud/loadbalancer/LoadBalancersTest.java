package net.litetex.hetzner.cloud.loadbalancer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;

import net.litetex.hetzner.cloud.CRUDTest;
import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.TestTags;
import net.litetex.hetzner.cloud.loadbalancer.response.LoadBalancer;


@SuppressWarnings("java:S2187") // Test are in parent
@Tag(TestTags.NON_FREE)
class LoadBalancersTest extends CRUDTest<LoadBalancersAPI, LoadBalancer>
{
	public LoadBalancersTest()
	{
		super(HetznerCloudAPI::loadBalancers);
	}
	
	@Override
	protected LoadBalancer create()
	{
		return this.api.create(b -> b.name("testLB")
			// LB11 -> Smallest LB
			.loadBalancerType("1")
			.location("nbg1")
		).loadBalancer();
	}
	
	@Override
	protected void update(final LoadBalancer created)
	{
		this.api.update(created.id(), b -> b.label("x", "y"));
	}
	
	@Override
	protected LoadBalancer get(final Long id)
	{
		final LoadBalancer loadBalancer = super.get(id);
		Assertions.assertEquals("y", loadBalancer.labels().get("x"));
		return loadBalancer;
	}
}
