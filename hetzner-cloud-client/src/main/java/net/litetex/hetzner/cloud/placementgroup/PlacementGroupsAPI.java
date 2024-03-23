package net.litetex.hetzner.cloud.placementgroup;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.placementgroup.request.CreatePlacementGroupRequest;
import net.litetex.hetzner.cloud.placementgroup.request.ListPlacementGroupsRequest;
import net.litetex.hetzner.cloud.placementgroup.response.CreatePlacementGroupResponse;
import net.litetex.hetzner.cloud.placementgroup.response.PlacementGroup;
import net.litetex.hetzner.cloud.placementgroup.response.PlacementGroupResponse;
import net.litetex.hetzner.cloud.placementgroup.response.PlacementGroupsResponse;
import net.litetex.hetzner.cloud.support.NameLabelsRequest;
import net.litetex.hetzner.cloud.support.api.NestedCRUDAPI;


public class PlacementGroupsAPI
	extends NestedCRUDAPI<PlacementGroupsResponse, PlacementGroup, ListPlacementGroupsRequest,
	PlacementGroupResponse,
	CreatePlacementGroupResponse, CreatePlacementGroupRequest, CreatePlacementGroupRequest.Builder,
	NameLabelsRequest, NameLabelsRequest.Builder>
{
	public PlacementGroupsAPI(final HetznerCloudAPI parentAPI)
	{
		super(
			parentAPI,
			"/placement_groups",
			PlacementGroupsResponse.class,
			ListPlacementGroupsRequest::new,
			PlacementGroupResponse.class,
			CreatePlacementGroupResponse.class,
			CreatePlacementGroupRequest.class,
			CreatePlacementGroupRequest.Builder::new,
			NameLabelsRequest.class,
			NameLabelsRequest.Builder::new);
	}
}
