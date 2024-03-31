package net.litetex.hetzner.cloud.iso;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.iso.request.ListISOsRequest;
import net.litetex.hetzner.cloud.iso.response.ISO;
import net.litetex.hetzner.cloud.iso.response.ISOResponse;
import net.litetex.hetzner.cloud.iso.response.ISOsResponse;
import net.litetex.hetzner.cloud.support.api.NestedReadAPI;


public class ISOsAPI extends NestedReadAPI<ISOsResponse, ISO, ListISOsRequest, ISOResponse>
{
	public ISOsAPI(final HetznerCloudAPI parentAPI)
	{
		super(parentAPI, "/isos", ISOsResponse.class, ListISOsRequest::new, ISOResponse.class);
	}
}
