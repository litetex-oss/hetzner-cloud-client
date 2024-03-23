package net.litetex.hetzner.cloud.primaryip;

import java.util.function.Consumer;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.actions.response.ActionResponse;
import net.litetex.hetzner.cloud.primaryip.request.AssignPrimaryIPRequest;
import net.litetex.hetzner.cloud.primaryip.request.CreatePrimaryIPRequest;
import net.litetex.hetzner.cloud.primaryip.request.ListPrimaryIPsRequest;
import net.litetex.hetzner.cloud.primaryip.request.UpdatePrimaryIPRequest;
import net.litetex.hetzner.cloud.primaryip.response.CreatePrimaryIPResponse;
import net.litetex.hetzner.cloud.primaryip.response.PrimaryIP;
import net.litetex.hetzner.cloud.primaryip.response.PrimaryIPResponse;
import net.litetex.hetzner.cloud.primaryip.response.PrimaryIPsResponse;
import net.litetex.hetzner.cloud.protection.ChangeProtectionAPI;
import net.litetex.hetzner.cloud.rdns.ChangeDNSPTRAPI;
import net.litetex.hetzner.cloud.support.BuilderUtil;
import net.litetex.hetzner.cloud.support.api.NestedCRUDAPI;


public class PrimaryIPsAPI
	extends NestedCRUDAPI<PrimaryIPsResponse, PrimaryIP, ListPrimaryIPsRequest,
	PrimaryIPResponse,
	CreatePrimaryIPResponse, CreatePrimaryIPRequest, CreatePrimaryIPRequest.Builder,
	UpdatePrimaryIPRequest, UpdatePrimaryIPRequest.Builder>
	implements ChangeDNSPTRAPI, ChangeProtectionAPI
{
	public PrimaryIPsAPI(final HetznerCloudAPI parentAPI)
	{
		super(
			parentAPI,
			"/primary_ips",
			PrimaryIPsResponse.class,
			ListPrimaryIPsRequest::new,
			PrimaryIPResponse.class,
			CreatePrimaryIPResponse.class,
			CreatePrimaryIPRequest.class,
			CreatePrimaryIPRequest.Builder::new,
			UpdatePrimaryIPRequest.class,
			UpdatePrimaryIPRequest.Builder::new);
	}
	
	public ActionResponse assign(final long id, final AssignPrimaryIPRequest assignPrimaryIPRequest)
	{
		return this.post(
			"/" + id + "/actions/assign",
			assignPrimaryIPRequest,
			ActionResponse.class);
	}
	
	public ActionResponse assign(final long id, final Consumer<AssignPrimaryIPRequest.Builder> builderConsumer)
	{
		return this.assign(id, BuilderUtil.build(AssignPrimaryIPRequest.Builder::new, builderConsumer));
	}
	
	public ActionResponse unassign(final long id)
	{
		return this.post(
			"/" + id + "/actions/unassign",
			ActionResponse.class);
	}
}
