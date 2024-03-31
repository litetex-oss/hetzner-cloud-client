package net.litetex.hetzner.cloud.iso;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.ReadOnlyAPITest;
import net.litetex.hetzner.cloud.iso.response.ISO;


@SuppressWarnings("java:S2187") // Test are in parent
class ISOsTest extends ReadOnlyAPITest<ISOsAPI, ISO>
{
	public ISOsTest()
	{
		super(HetznerCloudAPI::isos);
	}
}
