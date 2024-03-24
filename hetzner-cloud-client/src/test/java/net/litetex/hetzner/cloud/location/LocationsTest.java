package net.litetex.hetzner.cloud.location;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.ReadOnlyAPITest;
import net.litetex.hetzner.cloud.location.response.Location;


@SuppressWarnings("java:S2187") // Test are in parent
class LocationsTest extends ReadOnlyAPITest<LocationsAPI, Location>
{
	public LocationsTest()
	{
		super(HetznerCloudAPI::locations);
	}
}
