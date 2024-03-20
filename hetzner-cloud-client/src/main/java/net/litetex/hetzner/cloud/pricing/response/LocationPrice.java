package net.litetex.hetzner.cloud.pricing.response;

import com.fasterxml.jackson.annotation.JsonProperty;


public record LocationPrice(
	String location,
	@JsonProperty("price_hourly")
	Price priceHourly,
	@JsonProperty("price_monthly")
	Price priceMonthly
)
{
}
