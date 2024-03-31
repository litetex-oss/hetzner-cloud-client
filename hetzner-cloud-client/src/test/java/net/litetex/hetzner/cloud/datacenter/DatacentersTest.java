package net.litetex.hetzner.cloud.datacenter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.ReadOnlyAPITest;
import net.litetex.hetzner.cloud.datacenter.response.Datacenter;


class DatacentersTest extends ReadOnlyAPITest<DatacentersAPI, Datacenter>
{
	public DatacentersTest()
	{
		super(HetznerCloudAPI::datacenters);
	}
	
	@Test
	void checkRecommendation()
	{
		Assertions.assertTrue(this.api.list().recommendation() > 0);
	}
}
