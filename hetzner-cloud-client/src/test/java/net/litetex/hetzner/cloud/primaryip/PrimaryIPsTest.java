package net.litetex.hetzner.cloud.primaryip;

import org.junit.jupiter.api.Assertions;

import net.litetex.hetzner.cloud.CRUDTest;
import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.primaryip.response.PrimaryIP;
import net.litetex.hetzner.cloud.shared.IPType;


@SuppressWarnings("java:S2187") // Test are in parent
class PrimaryIPsTest extends CRUDTest<PrimaryIPsAPI, PrimaryIP>
{
	public PrimaryIPsTest()
	{
		super(HetznerCloudAPI::primaryIPs);
	}
	
	@Override
	protected PrimaryIP create()
	{
		return this.api.create(b -> b.name("test")
				// IPv6 costs no money
				.ipType(IPType.IPv6)
				.datacenter(this.hetznerCloudAPI.datacenters().list(db -> db.perPage(1)).datacenters().get(0).id()))
			.primaryIP();
	}
	
	@Override
	protected void update(final PrimaryIP created)
	{
		this.api.update(created.id(), b -> b.autoDelete(true));
	}
	
	@Override
	protected PrimaryIP get(final Long id)
	{
		final PrimaryIP primaryIP = super.get(id);
		Assertions.assertTrue(primaryIP.autoDelete());
		Assertions.assertEquals("test", primaryIP.name());
		return primaryIP;
	}
}
