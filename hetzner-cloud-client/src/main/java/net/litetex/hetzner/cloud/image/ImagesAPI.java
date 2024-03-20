package net.litetex.hetzner.cloud.image;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.actions.ActionsAPI;
import net.litetex.hetzner.cloud.image.request.ListImagesRequest;
import net.litetex.hetzner.cloud.image.request.UpdateImageRequest;
import net.litetex.hetzner.cloud.image.response.ImageResponse;
import net.litetex.hetzner.cloud.image.response.ImagesResponse;
import net.litetex.hetzner.cloud.protection.ChangeProtectionAPI;
import net.litetex.hetzner.cloud.support.api.DeleteAPI;
import net.litetex.hetzner.cloud.support.api.NestedRUAPI;


public class ImagesAPI
	extends NestedRUAPI<ImagesResponse, ListImagesRequest,
	ImageResponse,
	UpdateImageRequest, UpdateImageRequest.Builder>
	implements ActionsAPI, ChangeProtectionAPI, DeleteAPI
{
	public ImagesAPI(final HetznerCloudAPI parentAPI)
	{
		super(
			parentAPI,
			"/images",
			ImagesResponse.class,
			ListImagesRequest::new,
			ImageResponse.class,
			UpdateImageRequest.class,
			UpdateImageRequest.Builder::new);
	}
}
