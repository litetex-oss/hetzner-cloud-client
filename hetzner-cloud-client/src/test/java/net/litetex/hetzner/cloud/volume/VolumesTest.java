package net.litetex.hetzner.cloud.volume;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;

import net.litetex.hetzner.cloud.CRUDTest;
import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.TestTags;
import net.litetex.hetzner.cloud.volume.response.Volume;


@SuppressWarnings("java:S2187") // Test are in parent
@Tag(TestTags.NON_FREE)
class VolumesTest extends CRUDTest<VolumesAPI, Volume>
{
	public VolumesTest()
	{
		super(HetznerCloudAPI::volumes);
	}
	
	@Override
	protected Volume create()
	{
		return this.api.create(b -> b.name("testVol")
				.location("nbg1")
				// 10GB is smallest volume size
				.sizeInGB(10))
			.volume();
	}
	
	@Override
	protected void update(final Volume created)
	{
		this.api.update(created.id(), b -> b.label("x", "y"));
	}
	
	@Override
	protected Volume get(final Long id)
	{
		final Volume vol = super.get(id);
		Assertions.assertEquals("y", vol.labels().get("x"));
		return vol;
	}
}
