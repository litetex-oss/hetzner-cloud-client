package net.litetex.hetzner.cloud.datacenter;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.HetznerCloudTest;
import net.litetex.hetzner.cloud.datacenter.response.DatacentersResponse;


class DatacenterTest extends HetznerCloudTest<DatacentersAPI>
{
	public DatacenterTest()
	{
		super(HetznerCloudAPI::datacenters);
	}
	
	@Test
	void check()
	{
		final List<DatacentersResponse> responses = this.api.listAll();
		Assertions.assertFalse(responses.isEmpty());
		
		Assertions.assertTrue(responses.get(0).recommendation() > 0);
		Assertions.assertTrue(
			responses.stream().map(DatacentersResponse::datacenters).mapToLong(List::size).sum() > 0);
	}
}
