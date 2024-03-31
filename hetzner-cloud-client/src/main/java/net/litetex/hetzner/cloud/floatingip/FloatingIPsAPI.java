package net.litetex.hetzner.cloud.floatingip;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.actions.ActionsAPI;
import net.litetex.hetzner.cloud.actions.response.ActionResponse;
import net.litetex.hetzner.cloud.floatingip.request.AssignFloatingIPRequest;
import net.litetex.hetzner.cloud.floatingip.request.CreateFloatingIPRequest;
import net.litetex.hetzner.cloud.floatingip.request.UpdateFloatingIPRequest;
import net.litetex.hetzner.cloud.floatingip.response.CreateFloatingIPResponse;
import net.litetex.hetzner.cloud.floatingip.response.FloatingIP;
import net.litetex.hetzner.cloud.floatingip.response.FloatingIPResponse;
import net.litetex.hetzner.cloud.floatingip.response.FloatingIPsResponse;
import net.litetex.hetzner.cloud.list.request.DefaultListRequest;
import net.litetex.hetzner.cloud.protection.ChangeProtectionAPI;
import net.litetex.hetzner.cloud.rdns.ChangeDNSPTRAPI;
import net.litetex.hetzner.cloud.support.api.NestedCRUDAPI;


public class FloatingIPsAPI
	extends NestedCRUDAPI<FloatingIPsResponse, FloatingIP, DefaultListRequest,
	FloatingIPResponse,
	CreateFloatingIPResponse, CreateFloatingIPRequest, CreateFloatingIPRequest.Builder,
	UpdateFloatingIPRequest, UpdateFloatingIPRequest.Builder>
	implements ActionsAPI, ChangeProtectionAPI, ChangeDNSPTRAPI
{
	public FloatingIPsAPI(final HetznerCloudAPI parentAPI)
	{
		super(
			parentAPI,
			"/floating_ips",
			FloatingIPsResponse.class,
			DefaultListRequest::new,
			FloatingIPResponse.class,
			CreateFloatingIPResponse.class,
			CreateFloatingIPRequest.class,
			CreateFloatingIPRequest.Builder::new,
			UpdateFloatingIPRequest.class,
			UpdateFloatingIPRequest.Builder::new);
	}
	
	public ActionResponse assign(final long id, final long serverId)
	{
		return this.post("/" + id + "/actions/assign", new AssignFloatingIPRequest(serverId), ActionResponse.class);
	}
	
	public ActionResponse unassign(final long id)
	{
		return this.post("/" + id + "/actions/unassign", ActionResponse.class);
	}
}
