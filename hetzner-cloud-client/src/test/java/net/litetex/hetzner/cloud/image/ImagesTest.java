package net.litetex.hetzner.cloud.image;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.ReadOnlyAPITest;
import net.litetex.hetzner.cloud.image.response.Image;


@SuppressWarnings("java:S2187") // Test are in parent
class ImagesTest extends ReadOnlyAPITest<ImagesAPI, Image>
{
	public ImagesTest()
	{
		super(HetznerCloudAPI::images);
	}
}
