package net.litetex.hetzner.cloud.pricing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.litetex.hetzner.cloud.CloudTest;
import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.pricing.response.PricingResponse;


class PricingTest extends CloudTest<PricingAPI>
{
	public PricingTest()
	{
		super(HetznerCloudAPI::pricing);
	}
	
	@Test
	void check()
	{
		final PricingResponse pricingResponse = Assertions.assertDoesNotThrow(() -> this.api.get());
		Assertions.assertNotNull(pricingResponse.pricing().currency());
	}
}
