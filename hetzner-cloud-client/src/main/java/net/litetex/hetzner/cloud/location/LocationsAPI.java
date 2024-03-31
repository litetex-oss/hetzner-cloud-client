package net.litetex.hetzner.cloud.location;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.list.request.DefaultListRequest;
import net.litetex.hetzner.cloud.location.response.Location;
import net.litetex.hetzner.cloud.location.response.LocationResponse;
import net.litetex.hetzner.cloud.location.response.LocationsResponse;
import net.litetex.hetzner.cloud.support.api.NestedReadAPI;


public class LocationsAPI extends NestedReadAPI<LocationsResponse, Location, DefaultListRequest, LocationResponse>
{
	public LocationsAPI(final HetznerCloudAPI parentAPI)
	{
		super(parentAPI, "/locations", LocationsResponse.class, DefaultListRequest::new, LocationResponse.class);
	}
}
