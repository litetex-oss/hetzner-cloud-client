package net.litetex.hetzner.cloud.image.response;

import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record ImageResponse(
	Image image
) implements SingleResponse<Image>
{
	@Override
	public Image data()
	{
		return this.image();
	}
}
