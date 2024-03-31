package net.litetex.hetzner.cloud.loadbalancertype;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.list.request.DefaultListRequest;
import net.litetex.hetzner.cloud.loadbalancertype.response.LoadBalancerType;
import net.litetex.hetzner.cloud.loadbalancertype.response.LoadBalancerTypeResponse;
import net.litetex.hetzner.cloud.loadbalancertype.response.LoadBalancerTypesResponse;
import net.litetex.hetzner.cloud.support.api.NestedReadAPI;


public class LoadBalancerTypesAPI
	extends NestedReadAPI<LoadBalancerTypesResponse, LoadBalancerType, DefaultListRequest, LoadBalancerTypeResponse>
{
	public LoadBalancerTypesAPI(final HetznerCloudAPI parentAPI)
	{
		super(
			parentAPI,
			"/load_balancer_types",
			LoadBalancerTypesResponse.class,
			DefaultListRequest::new,
			LoadBalancerTypeResponse.class);
	}
}
