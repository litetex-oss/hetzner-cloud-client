package net.litetex.hetzner.cloud.floatingip;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;

import net.litetex.hetzner.cloud.CRUDTest;
import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.TestTags;
import net.litetex.hetzner.cloud.floatingip.response.FloatingIP;
import net.litetex.hetzner.cloud.shared.IPType;


@SuppressWarnings("java:S2187") // Test are in parent
@Tag(TestTags.NON_FREE)
class FloatingIPsTest extends CRUDTest<FloatingIPsAPI, FloatingIP>
{
	public FloatingIPsTest()
	{
		super(HetznerCloudAPI::floatingIPs);
	}
	
	@Override
	protected FloatingIP create()
	{
		return this.api.create(b -> b.name("test")
				.ipType(IPType.IPv6))
			.floatingIP();
	}
	
	@Override
	protected void update(final FloatingIP created)
	{
		this.api.update(created.id(), b -> b.label("x", "y"));
	}
	
	@Override
	protected FloatingIP get(final Long id)
	{
		final FloatingIP floatingIP = super.get(id);
		Assertions.assertEquals("y", floatingIP.labels().get("x"));
		return floatingIP;
	}
}
