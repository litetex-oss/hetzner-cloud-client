package net.litetex.hetzner.cloud.servervolume;

import java.util.Comparator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;

import net.litetex.hetzner.cloud.CRUDTest;
import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.TestTags;
import net.litetex.hetzner.cloud.image.request.ImageType;
import net.litetex.hetzner.cloud.image.response.Image;
import net.litetex.hetzner.cloud.server.ServersAPI;
import net.litetex.hetzner.cloud.server.response.Server;


@SuppressWarnings("java:S2187") // Test are in parent
@Tag(TestTags.NON_FREE)
class ServersTest extends CRUDTest<ServersAPI, Server>
{
	public ServersTest()
	{
		super(HetznerCloudAPI::servers);
	}
	
	@Override
	protected Server create()
	{
		final long imageId = this.hetznerCloudAPI.images().listAllData(b -> b.architecture("arm")
				.type(ImageType.SYSTEM))
			.stream()
			.filter(i -> i.name().startsWith("ubuntu"))
			// Use latest ubuntu (LTS) version
			.max(Comparator.comparing(Image::osVersion))
			.orElseThrow()
			.id();
		
		final String datacenterName = this.hetznerCloudAPI.datacenters().listAllData()
			.stream()
			.filter(d -> "nbg1".equals(d.location().name()))
			.findFirst()
			.orElseThrow()
			.name();
		
		return this.api.create(b -> b.name("test")
			.datacenter(datacenterName)
			// Smallest ARM machine
			.serverType("cax11")
			.publicNet(pb -> pb
				.enableIPv4(false)
				.enableIPv6(false))
			.image(imageId)
			.startAfterCreate(false)
		).server();
	}
	
	@Override
	protected void update(final Server created)
	{
		this.api.update(created.id(), b -> b.label("x", "y"));
	}
	
	@Override
	protected Server get(final Long id)
	{
		final Server server = super.get(id);
		Assertions.assertEquals("y", server.labels().get("x"));
		return server;
	}
	
	@Override
	protected void delete(final Server created)
	{
		this.api.delete(created.id());
		super.delete(created);
	}
	
	@AfterEach
	@Override
	protected void afterEach()
	{
		this.api.listAllData().forEach(s -> this.api.delete(s.id()));
	}
}
