package net.litetex.hetzner.cloud.pricing;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.pricing.response.PricingResponse;
import net.litetex.hetzner.cloud.support.api.NestedAPI;


public class PricingAPI extends NestedAPI
{
	public PricingAPI(final HetznerCloudAPI parentAPI)
	{
		super(parentAPI, "/pricing");
	}
	
	public PricingResponse get()
	{
		return this.get("", PricingResponse.class);
	}
}
