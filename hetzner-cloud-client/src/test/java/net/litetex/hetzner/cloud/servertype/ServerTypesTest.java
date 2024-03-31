package net.litetex.hetzner.cloud.servertype;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.ReadOnlyAPITest;
import net.litetex.hetzner.cloud.servertype.reponse.ServerType;


@SuppressWarnings("java:S2187") // Test are in parent
class ServerTypesTest extends ReadOnlyAPITest<ServerTypesAPI, ServerType>
{
	public ServerTypesTest()
	{
		super(HetznerCloudAPI::serverTypes);
	}
}
