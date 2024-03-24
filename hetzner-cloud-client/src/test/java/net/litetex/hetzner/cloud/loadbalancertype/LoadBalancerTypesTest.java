package net.litetex.hetzner.cloud.loadbalancertype;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.ReadOnlyAPITest;
import net.litetex.hetzner.cloud.loadbalancertype.response.LoadBalancerType;


@SuppressWarnings("java:S2187") // Test are in parent
class LoadBalancerTypesTest extends ReadOnlyAPITest<LoadBalancerTypesAPI, LoadBalancerType>
{
	public LoadBalancerTypesTest()
	{
		super(HetznerCloudAPI::loadBalancerTypes);
	}
}
