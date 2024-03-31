package net.litetex.hetzner.cloud.pricing.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public record Pricing(
	@JsonProperty("vat_rate")
	double vatRate,
	String currency,
	@JsonProperty("floating_ip")
	FloatingIP floatingIP,
	@JsonProperty("floating_ips")
	List<FloatingIPs> floatingIPs,
	Image image,
	@JsonProperty("load_balancer_types")
	List<LoadBalancerType> loadBalancerTypes,
	@JsonProperty("primary_ips")
	List<PrimaryIP> primaryIPs,
	@JsonProperty("server_backup")
	ServerBackup serverBackup,
	@JsonProperty("server_types")
	List<ServerType> serverTypes,
	Traffic traffic,
	Volume volume)
{
	public record FloatingIP(
		@JsonProperty("price_monthly")
		Price priceMonthly)
	{
	}
	
	
	public record FloatingIPs(
		@JsonProperty("type")
		String ipType,
		List<LocationPrice> prices)
	{
	}
	
	
	public record Image(
		@JsonProperty("price_per_gb_month")
		Price pricePerGBMonth)
	{
	}
	
	
	public record LoadBalancerType(
		long id,
		String name,
		List<LocationPrice> prices)
	{
	}
	
	
	public record PrimaryIP(
		@JsonProperty("type")
		String ipType,
		List<LocationPrice> prices)
	{
	}
	
	
	public record ServerBackup(
		double percentage)
	{
	}
	
	
	public record ServerType(
		long id,
		String name,
		List<LocationPrice> prices)
	{
	}
	
	
	public record Traffic(
		@JsonProperty("price_per_tb")
		Price pricePerTB)
	{
	}
	
	
	public record Volume(
		@JsonProperty("price_per_gb_month")
		Price pricePerGBMonth)
	{
	}
}
