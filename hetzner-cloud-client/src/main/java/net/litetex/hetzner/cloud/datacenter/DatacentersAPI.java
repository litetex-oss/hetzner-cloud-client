package net.litetex.hetzner.cloud.datacenter;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.datacenter.response.DatacenterResponse;
import net.litetex.hetzner.cloud.datacenter.response.DatacentersResponse;
import net.litetex.hetzner.cloud.list.request.DefaultListRequest;
import net.litetex.hetzner.cloud.support.api.NestedReadAPI;


public class DatacentersAPI
	extends NestedReadAPI<DatacentersResponse, DefaultListRequest, DatacenterResponse>
{
	public DatacentersAPI(final HetznerCloudAPI parentAPI)
	{
		super(
			parentAPI,
			"/datacenters",
			DatacentersResponse.class,
			DefaultListRequest::new,
			DatacenterResponse.class);
	}
}
