package net.litetex.hetzner.cloud.placementgroup;

import org.junit.jupiter.api.Assertions;

import net.litetex.hetzner.cloud.CRUDTest;
import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.placementgroup.response.PlacementGroup;


@SuppressWarnings("java:S2187") // Test are in parent
class PlacementGroupsTest extends CRUDTest<PlacementGroupsAPI, PlacementGroup>
{
	public PlacementGroupsTest()
	{
		super(HetznerCloudAPI::placementGroups);
	}
	
	@Override
	protected PlacementGroup create()
	{
		return this.api.create(b -> b.name("test"))
			.placementGroup();
	}
	
	@Override
	protected void update(final PlacementGroup created)
	{
		this.api.update(created.id(), b -> b.label("x", "y"));
	}
	
	@Override
	protected PlacementGroup get(final Long id)
	{
		final PlacementGroup placementGroup = super.get(id);
		Assertions.assertEquals("test", placementGroup.name());
		Assertions.assertEquals("y", placementGroup.labels().get("x"));
		return placementGroup;
	}
}
