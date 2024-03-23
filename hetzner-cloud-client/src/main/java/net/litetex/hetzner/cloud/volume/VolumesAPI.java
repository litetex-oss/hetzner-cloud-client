package net.litetex.hetzner.cloud.volume;

import java.util.function.Consumer;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.actions.ActionsAPI;
import net.litetex.hetzner.cloud.actions.response.ActionResponse;
import net.litetex.hetzner.cloud.list.request.DefaultListRequest;
import net.litetex.hetzner.cloud.protection.ChangeProtectionAPI;
import net.litetex.hetzner.cloud.support.BuilderUtil;
import net.litetex.hetzner.cloud.support.NameLabelsRequest;
import net.litetex.hetzner.cloud.support.api.NestedCRUDAPI;
import net.litetex.hetzner.cloud.volume.request.AttachVolumeRequest;
import net.litetex.hetzner.cloud.volume.request.CreateVolumeRequest;
import net.litetex.hetzner.cloud.volume.request.ResizeVolumeRequest;
import net.litetex.hetzner.cloud.volume.response.CreateVolumeResponse;
import net.litetex.hetzner.cloud.volume.response.Volume;
import net.litetex.hetzner.cloud.volume.response.VolumeResponse;
import net.litetex.hetzner.cloud.volume.response.VolumesResponse;


public class VolumesAPI
	extends NestedCRUDAPI<VolumesResponse, Volume, DefaultListRequest,
	VolumeResponse,
	CreateVolumeResponse, CreateVolumeRequest, CreateVolumeRequest.Builder,
	NameLabelsRequest, NameLabelsRequest.Builder>
	implements ActionsAPI, ChangeProtectionAPI
{
	public VolumesAPI(final HetznerCloudAPI parentAPI)
	{
		super(
			parentAPI,
			"/volumes",
			VolumesResponse.class,
			DefaultListRequest::new,
			VolumeResponse.class,
			CreateVolumeResponse.class,
			CreateVolumeRequest.class,
			CreateVolumeRequest.Builder::new,
			NameLabelsRequest.class,
			NameLabelsRequest.Builder::new);
	}
	
	public ActionResponse attachToServer(final long id, final AttachVolumeRequest attachVolumeRequest)
	{
		return this.post("/" + id + "/actions/attach", attachVolumeRequest, ActionResponse.class);
	}
	
	public ActionResponse attachToServer(final long id, final Consumer<AttachVolumeRequest.Builder> builderConsumer)
	{
		return this.attachToServer(id, BuilderUtil.build(AttachVolumeRequest.Builder::new, builderConsumer));
	}
	
	public ActionResponse detach(final long id)
	{
		return this.post("/" + id + "/actions/detach", ActionResponse.class);
	}
	
	public ActionResponse resize(final long id, final ResizeVolumeRequest resizeVolumeRequest)
	{
		return this.post("/" + id + "/actions/resize", resizeVolumeRequest, ActionResponse.class);
	}
	
	public ActionResponse resize(final long id, final long sizeInGB)
	{
		return this.resize(id, new ResizeVolumeRequest(sizeInGB));
	}
}
