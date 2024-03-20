package net.litetex.hetzner.cloud;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


public class RelativeUrlBuilder
{
	private final String url;
	
	private final Map<String, String> queryParams = new HashMap<>();
	
	public RelativeUrlBuilder()
	{
		this("");
	}
	
	public RelativeUrlBuilder(final String url)
	{
		this.url = Objects.requireNonNull(url);
	}
	
	public RelativeUrlBuilder queryParam(final String name, final Object value)
	{
		if(value != null)
		{
			this.queryParams.put(name, Objects.toString(value));
		}
		return this;
	}
	
	public String build()
	{
		if(this.queryParams.isEmpty())
		{
			return this.url;
		}
		
		return this.url + "?" + this.queryParams.entrySet()
			.stream()
			.map(e -> e.getKey() + "=" + e.getValue())
			.collect(Collectors.joining("&"));
	}
}
