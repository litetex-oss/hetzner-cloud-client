package net.litetex.hetzner.cloud.server.response;

import net.litetex.hetzner.cloud.actions.response.Action;
import net.litetex.hetzner.cloud.image.response.Image;
import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record CreateImageResponse(
    Image image,
	Action action
) implements SingleResponse<Image>
{
	@Override
	public Image data()
	{
		return this.image();
	}
}
