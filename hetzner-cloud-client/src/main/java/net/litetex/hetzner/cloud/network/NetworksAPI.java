package net.litetex.hetzner.cloud.network;

import java.util.function.Consumer;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.actions.response.ActionResponse;
import net.litetex.hetzner.cloud.list.request.DefaultListRequest;
import net.litetex.hetzner.cloud.network.request.AddSubnetToNetworkRequest;
import net.litetex.hetzner.cloud.network.request.ChangeIPRangeOfNetworkRequest;
import net.litetex.hetzner.cloud.network.request.CreateNetworkRequest;
import net.litetex.hetzner.cloud.network.request.DeleteSubnetFromNetwork;
import net.litetex.hetzner.cloud.network.request.NetworkRouteRequest;
import net.litetex.hetzner.cloud.network.request.UpdateNetworkRequest;
import net.litetex.hetzner.cloud.network.response.NetworkResponse;
import net.litetex.hetzner.cloud.network.response.NetworksResponse;
import net.litetex.hetzner.cloud.protection.ChangeProtectionAPI;
import net.litetex.hetzner.cloud.support.BuilderUtil;
import net.litetex.hetzner.cloud.support.api.NestedCRUDAPI;


public class NetworksAPI
	extends NestedCRUDAPI<NetworksResponse, DefaultListRequest,
	NetworkResponse,
	NetworkResponse, CreateNetworkRequest, CreateNetworkRequest.Builder,
	UpdateNetworkRequest, UpdateNetworkRequest.Builder>
	implements ChangeProtectionAPI
{
	public NetworksAPI(final HetznerCloudAPI parentAPI)
	{
		super(
			parentAPI,
			"/networks",
			NetworksResponse.class,
			DefaultListRequest::new,
			NetworkResponse.class,
			NetworkResponse.class,
			CreateNetworkRequest.class,
			CreateNetworkRequest.Builder::new,
			UpdateNetworkRequest.class,
			UpdateNetworkRequest.Builder::new);
	}
	
	public ActionResponse addSubnet(final long id, final AddSubnetToNetworkRequest addSubnetToNetworkRequest)
	{
		return this.post("/" + id + "/actions/add_subnet", addSubnetToNetworkRequest, ActionResponse.class);
	}
	
	public ActionResponse addSubnet(final long id, final Consumer<AddSubnetToNetworkRequest.Builder> builderConsumer)
	{
		return this.addSubnet(id, BuilderUtil.build(AddSubnetToNetworkRequest.Builder::new, builderConsumer));
	}
	
	public ActionResponse deleteSubnet(final long id, final DeleteSubnetFromNetwork deleteSubnetFromNetwork)
	{
		return this.post("/" + id + "/actions/delete_subnet", deleteSubnetFromNetwork, ActionResponse.class);
	}
	
	public ActionResponse deleteSubnet(final long id, final String ipRange)
	{
		return this.deleteSubnet(id, new DeleteSubnetFromNetwork(ipRange));
	}
	
	public ActionResponse addRoute(final long id, final NetworkRouteRequest networkRouteRequest)
	{
		return this.post("/" + id + "/actions/add_route", networkRouteRequest, ActionResponse.class);
	}
	
	public ActionResponse addRoute(final long id, final Consumer<NetworkRouteRequest.Builder> builderConsumer)
	{
		return this.addRoute(id, BuilderUtil.build(NetworkRouteRequest.Builder::new, builderConsumer));
	}
	
	public ActionResponse deleteRoute(final long id, final NetworkRouteRequest networkRouteRequest)
	{
		return this.post("/" + id + "/actions/delete_route", networkRouteRequest, ActionResponse.class);
	}
	
	public ActionResponse deleteRoute(final long id, final Consumer<NetworkRouteRequest.Builder> builderConsumer)
	{
		return this.deleteRoute(id, BuilderUtil.build(NetworkRouteRequest.Builder::new, builderConsumer));
	}
	
	public ActionResponse changeIPRange(
		final long id,
		final ChangeIPRangeOfNetworkRequest changeIPRangeOfNetworkRequest)
	{
		return this.post("/" + id + "/actions/change_ip_range", changeIPRangeOfNetworkRequest, ActionResponse.class);
	}
	
	public ActionResponse changeIPRange(final long id, final String ipRange)
	{
		return this.changeIPRange(id, new ChangeIPRangeOfNetworkRequest(ipRange));
	}
}
