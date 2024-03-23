package net.litetex.hetzner.cloud.loadbalancer;

import java.util.function.Consumer;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.actions.ActionsAPI;
import net.litetex.hetzner.cloud.actions.response.ActionResponse;
import net.litetex.hetzner.cloud.list.request.DefaultListRequest;
import net.litetex.hetzner.cloud.loadbalancer.request.CreateLoadBalancerRequest;
import net.litetex.hetzner.cloud.loadbalancer.request.LoadBalancerChangeAlgorithmRequest;
import net.litetex.hetzner.cloud.loadbalancer.request.LoadBalancerChangeTypeRequest;
import net.litetex.hetzner.cloud.loadbalancer.request.LoadBalancerDeleteServiceRequest;
import net.litetex.hetzner.cloud.loadbalancer.request.LoadBalancerNetworkRequest;
import net.litetex.hetzner.cloud.loadbalancer.request.LoadBalancerTargetRequest;
import net.litetex.hetzner.cloud.loadbalancer.request.UpdateLoadBalancerServiceRequest;
import net.litetex.hetzner.cloud.loadbalancer.response.CreateLoadBalancerResponse;
import net.litetex.hetzner.cloud.loadbalancer.response.LoadBalancer;
import net.litetex.hetzner.cloud.loadbalancer.response.LoadBalancerResponse;
import net.litetex.hetzner.cloud.loadbalancer.response.LoadBalancersResponse;
import net.litetex.hetzner.cloud.loadbalancer.shared.service.LBService;
import net.litetex.hetzner.cloud.protection.ChangeProtectionAPI;
import net.litetex.hetzner.cloud.support.BuilderUtil;
import net.litetex.hetzner.cloud.support.NameLabelsRequest;
import net.litetex.hetzner.cloud.support.api.NestedCRUDAPI;


public class LoadBalancersAPI
	extends NestedCRUDAPI<LoadBalancersResponse, LoadBalancer, DefaultListRequest,
	LoadBalancerResponse,
	CreateLoadBalancerResponse, CreateLoadBalancerRequest, CreateLoadBalancerRequest.Builder,
	NameLabelsRequest, NameLabelsRequest.Builder>
	implements ActionsAPI, ChangeProtectionAPI
{
	public LoadBalancersAPI(final HetznerCloudAPI parentAPI)
	{
		super(
			parentAPI,
			"/load_balancers",
			LoadBalancersResponse.class,
			DefaultListRequest::new,
			LoadBalancerResponse.class,
			CreateLoadBalancerResponse.class,
			CreateLoadBalancerRequest.class,
			CreateLoadBalancerRequest.Builder::new,
			NameLabelsRequest.class,
			NameLabelsRequest.Builder::new);
	}
	
	public LoadBalancerResponse addService(final long id, final LBService lbServiceRequest)
	{
		return this.post(
			"/" + id + "/actions/add_service",
			lbServiceRequest,
			LoadBalancerResponse.class);
	}
	
	public LoadBalancerResponse addService(
		final long id,
		final Consumer<LBService.Builder> builderConsumer)
	{
		return this.addService(
			id,
			BuilderUtil.build(LBService.Builder::new, builderConsumer));
	}
	
	public LoadBalancerResponse updateService(final long id, final UpdateLoadBalancerServiceRequest lbServiceRequest)
	{
		return this.post("/" + id + "/actions/update_service", lbServiceRequest, LoadBalancerResponse.class);
	}
	
	public LoadBalancerResponse updateService(
		final long id,
		final Consumer<UpdateLoadBalancerServiceRequest.Builder> builderConsumer)
	{
		return this.updateService(
			id,
			BuilderUtil.build(UpdateLoadBalancerServiceRequest.Builder::new, builderConsumer));
	}
	
	public ActionResponse deleteService(final long id, final long listenPort)
	{
		return this.post(
			"/" + id + "/actions/delete_service",
			new LoadBalancerDeleteServiceRequest(listenPort),
			ActionResponse.class);
	}
	
	public ActionResponse addTarget(final long id, final LoadBalancerTargetRequest lbTargetRequest)
	{
		return this.post(
			"/" + id + "/actions/add_target",
			lbTargetRequest,
			ActionResponse.class);
	}
	
	public ActionResponse addTarget(final long id, final Consumer<LoadBalancerTargetRequest.Builder> builderConsumer)
	{
		return this.addTarget(id, BuilderUtil.build(LoadBalancerTargetRequest.Builder::new, builderConsumer));
	}
	
	public ActionResponse removeTarget(final long id, final LoadBalancerTargetRequest lbTargetRequest)
	{
		return this.post(
			"/" + id + "/actions/remove_target",
			lbTargetRequest,
			ActionResponse.class);
	}
	
	public ActionResponse removeTarget(
		final long id,
		final Consumer<LoadBalancerTargetRequest.Builder> builderConsumer)
	{
		return this.removeTarget(id, BuilderUtil.build(LoadBalancerTargetRequest.Builder::new, builderConsumer));
	}
	
	public ActionResponse changeAlgorithm(final long id, final String algorithmType)
	{
		return this.post(
			"/" + id + "/actions/change_algorithm",
			new LoadBalancerChangeAlgorithmRequest(algorithmType),
			ActionResponse.class);
	}
	
	public ActionResponse changeType(final long id, final String loadBalancerType)
	{
		return this.post(
			"/" + id + "/actions/change_type",
			new LoadBalancerChangeTypeRequest(loadBalancerType),
			ActionResponse.class);
	}
	
	public ActionResponse attachNetwork(final long id, final LoadBalancerNetworkRequest request)
	{
		return this.post(
			"/" + id + "/actions/attach_to_network",
			request,
			ActionResponse.class);
	}
	
	public ActionResponse attachNetwork(
		final long id,
		final Consumer<LoadBalancerNetworkRequest.Builder> builderConsumer)
	{
		return this.attachNetwork(id, this.build(LoadBalancerNetworkRequest.Builder::new, builderConsumer));
	}
	
	public ActionResponse detachNetwork(final long id, final long networkId)
	{
		return this.post(
			"/" + id + "/actions/detach_from_network",
			new LoadBalancerNetworkRequest(networkId),
			ActionResponse.class);
	}
	
	public ActionResponse enablePublicInterface(final long id)
	{
		return this.post(
			"/" + id + "/actions/enable_public_interface",
			ActionResponse.class);
	}
	
	public ActionResponse disablePublicInterfaceOfLoadBalancer(final long id)
	{
		return this.post(
			"/" + id + "/actions/disable_public_interface",
			ActionResponse.class);
	}
}
