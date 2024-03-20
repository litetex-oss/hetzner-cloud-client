package net.litetex.hetzner.cloud.server;

import java.util.function.Consumer;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.RelativeUrlBuilder;
import net.litetex.hetzner.cloud.actions.ActionsAPI;
import net.litetex.hetzner.cloud.actions.response.ActionResponse;
import net.litetex.hetzner.cloud.protection.ChangeProtectionAPI;
import net.litetex.hetzner.cloud.rdns.ChangeDNSPTRAPI;
import net.litetex.hetzner.cloud.server.request.AttachISORequest;
import net.litetex.hetzner.cloud.server.request.AttachServerToNetworkRequest;
import net.litetex.hetzner.cloud.server.request.ChangeAliasIPsOfNetworkRequest;
import net.litetex.hetzner.cloud.server.request.ChangeTypeRequest;
import net.litetex.hetzner.cloud.server.request.CreateImageRequest;
import net.litetex.hetzner.cloud.server.request.CreateServerRequest;
import net.litetex.hetzner.cloud.server.request.DetachServerFromNetworkRequest;
import net.litetex.hetzner.cloud.server.request.EnableRescueRequest;
import net.litetex.hetzner.cloud.server.request.ListServersRequest;
import net.litetex.hetzner.cloud.server.request.PlacementGroupAddServerRequest;
import net.litetex.hetzner.cloud.server.request.RebuildServerRequest;
import net.litetex.hetzner.cloud.server.response.ConsoleResponse;
import net.litetex.hetzner.cloud.server.response.CreateImageResponse;
import net.litetex.hetzner.cloud.server.response.CreateServerResponse;
import net.litetex.hetzner.cloud.server.response.EnableRescueResponse;
import net.litetex.hetzner.cloud.server.response.MetricsResponse;
import net.litetex.hetzner.cloud.server.response.RebuildServerResponse;
import net.litetex.hetzner.cloud.server.response.ResetRootPasswordResponse;
import net.litetex.hetzner.cloud.server.response.ServerResponse;
import net.litetex.hetzner.cloud.server.response.ServersResponse;
import net.litetex.hetzner.cloud.support.BuilderUtil;
import net.litetex.hetzner.cloud.support.NameLabelsRequest;
import net.litetex.hetzner.cloud.support.api.NestedCRUAPI;


public class ServersAPI
	extends NestedCRUAPI<ServersResponse, ListServersRequest,
	ServerResponse,
	CreateServerResponse, CreateServerRequest, CreateServerRequest.Builder,
	NameLabelsRequest, NameLabelsRequest.Builder>
	implements ActionsAPI, ChangeProtectionAPI, ChangeDNSPTRAPI
{
	public ServersAPI(final HetznerCloudAPI parentAPI)
	{
		super(
			parentAPI,
			"/servers",
			ServersResponse.class,
			ListServersRequest::new,
			ServerResponse.class,
			CreateServerResponse.class,
			CreateServerRequest.class,
			CreateServerRequest.Builder::new,
			NameLabelsRequest.class,
			NameLabelsRequest.Builder::new);
	}
	
	public ActionResponse delete(final long id)
	{
		return this.delete("/" + id, ActionResponse.class);
	}
	
	public ConsoleResponse requestConsole(final long id)
	{
		return this.post("/" + id + "/actions/request_console", ConsoleResponse.class);
	}
	
	public ActionResponse addToPlacementGroup(final long serverId, final long placementGroupId)
	{
		return this.post(
			"/" + serverId + "/actions/add_to_placement_group",
			new PlacementGroupAddServerRequest(placementGroupId),
			ActionResponse.class);
	}
	
	public ActionResponse removeFromPlacementGroup(final long serverId)
	{
		return this.post(
			"/" + serverId + "/actions/remove_from_placement_group",
			ActionResponse.class);
	}
	
	public ActionResponse powerOn(final long id)
	{
		return this.post("/" + id + "/actions/poweron", ActionResponse.class);
	}
	
	public ActionResponse powerOff(final long id)
	{
		return this.post("/" + id + "/actions/poweroff", ActionResponse.class);
	}
	
	public ActionResponse reboot(final long id)
	{
		return this.post("/" + id + "/actions/reboot", ActionResponse.class);
	}
	
	public ActionResponse reset(final long id)
	{
		return this.post("/" + id + "/actions/reset", ActionResponse.class);
	}
	
	public ActionResponse shutdown(final long id)
	{
		return this.post("/" + id + "/actions/shutdown", ActionResponse.class);
	}
	
	public ResetRootPasswordResponse resetRootPassword(final long id)
	{
		return this.post("/" + id + "/actions/reset_password", ResetRootPasswordResponse.class);
	}
	
	public EnableRescueResponse enableRescue(final long id)
	{
		return this.post("/" + id + "/actions/enable_rescue", EnableRescueResponse.class);
	}
	
	public EnableRescueResponse enableRescue(final long id, final EnableRescueRequest enableRescueRequest)
	{
		return this.post("/" + id + "/actions/enable_rescue", enableRescueRequest, EnableRescueResponse.class);
	}
	
	public EnableRescueResponse enableRescue(
		final long id,
		final Consumer<EnableRescueRequest.Builder> builderConsumer)
	{
		return this.enableRescue(id, BuilderUtil.build(EnableRescueRequest.Builder::new, builderConsumer));
	}
	
	public ActionResponse disableRescue(final long id)
	{
		return this.post("/" + id + "/actions/disable_rescue", ActionResponse.class);
	}
	
	public RebuildServerResponse rebuildServer(final long id, final RebuildServerRequest rebuildServerRequest)
	{
		return this.post("/" + id + "/actions/rebuild", rebuildServerRequest, RebuildServerResponse.class);
	}
	
	public RebuildServerResponse rebuildServer(final long id, final String image)
	{
		return this.rebuildServer(id, new RebuildServerRequest(image));
	}
	
	public ActionResponse changeServerType(final long id, final ChangeTypeRequest changeTypeRequest)
	{
		return this.post("/" + id + "/actions/change_type", changeTypeRequest, ActionResponse.class);
	}
	
	public ActionResponse changeServerType(
		final long id,
		final Consumer<ChangeTypeRequest.Builder> builderConsumer)
	{
		return this.changeServerType(id, BuilderUtil.build(ChangeTypeRequest.Builder::new, builderConsumer));
	}
	
	public MetricsResponse getServerMetrics(
		final long id,
		final String metricType,
		final String start,
		final String end)
	{
		return this.get(
			new RelativeUrlBuilder("/" + id + "/metrics")
				.queryParam("type", metricType)
				.queryParam("start", start)
				.queryParam("end", end)
				.build(),
			MetricsResponse.class);
	}
	
	public CreateImageResponse createImage(final long id, final CreateImageRequest createImageRequest)
	{
		return this.post("/" + id + "/actions/create_image", createImageRequest, CreateImageResponse.class);
	}
	
	public CreateImageResponse createImage(final long id, final Consumer<CreateImageRequest.Builder> builderConsumer)
	{
		return this.createImage(id, BuilderUtil.build(CreateImageRequest.Builder::new, builderConsumer));
	}
	
	public ActionResponse enableBackup(final long id)
	{
		return this.post("/" + id + "/actions/enable_backup", ActionResponse.class);
	}
	
	public ActionResponse attachISO(final long id, final AttachISORequest attachISORequest)
	{
		return this.post("/" + id + "/actions/attach_iso", attachISORequest, ActionResponse.class);
	}
	
	public ActionResponse attachISO(final long id, final String iso)
	{
		return this.attachISO(id, new AttachISORequest(iso));
	}
	
	public ActionResponse detachISO(final long id)
	{
		return this.post("/" + id + "/actions/detach_iso", ActionResponse.class);
	}
	
	public ActionResponse attachServerToNetwork(
		final long id,
		final AttachServerToNetworkRequest attachServerToNetworkRequest)
	{
		return this.post("/" + id + "/actions/attach_to_network", attachServerToNetworkRequest, ActionResponse.class);
	}
	
	public ActionResponse attachServerToNetwork(
		final long id,
		final Consumer<AttachServerToNetworkRequest.Builder> builderConsumer)
	{
		return this.attachServerToNetwork(
			id,
			BuilderUtil.build(AttachServerToNetworkRequest.Builder::new, builderConsumer));
	}
	
	public ActionResponse detachServerFromNetwork(
		final long id,
		final DetachServerFromNetworkRequest detachServerFromNetworkRequest)
	{
		return this.post(
			"/" + id + "/actions/detach_from_network",
			detachServerFromNetworkRequest,
			ActionResponse.class);
	}
	
	public ActionResponse detachServerFromNetwork(final long id, final long networkId)
	{
		return this.detachServerFromNetwork(id, new DetachServerFromNetworkRequest(networkId));
	}
	
	public ActionResponse changeAliasIPsOfNetwork(
		final long id,
		final ChangeAliasIPsOfNetworkRequest changeAliasIPsofNetworkRequest)
	{
		return this.post("/" + id + "/actions/change_alias_ips", changeAliasIPsofNetworkRequest, ActionResponse.class);
	}
	
	public ActionResponse changeAliasIPsOfNetwork(
		final long id,
		final Consumer<ChangeAliasIPsOfNetworkRequest.Builder> builderConsumer)
	{
		return this.changeAliasIPsOfNetwork(
			id,
			BuilderUtil.build(ChangeAliasIPsOfNetworkRequest.Builder::new, builderConsumer));
	}
}
