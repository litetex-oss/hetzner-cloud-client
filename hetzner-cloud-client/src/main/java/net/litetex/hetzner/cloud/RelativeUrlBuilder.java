package net.litetex.hetzner.cloud;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class RelativeUrlBuilder
{
	private final String url;
	
	private final List<QueryParam> queryParams = new ArrayList<>();
	
	public RelativeUrlBuilder()
	{
		this("");
	}
	
	public RelativeUrlBuilder(final String url)
	{
		this.url = Objects.requireNonNull(url);
	}
	
	public RelativeUrlBuilder queryParams(final String name, final List<?> values)
	{
		values.forEach(v -> this.queryParam(name, v));
		return this;
	}
	
	public RelativeUrlBuilder queryParam(final String name, final Object value)
	{
		if(value != null)
		{
			this.queryParams.add(new QueryParam(name, Objects.toString(value)));
		}
		return this;
	}
	
	public String build()
	{
		if(this.queryParams.isEmpty())
		{
			return this.url;
		}
		
		return this.url + "?" + this.queryParams
			.stream()
			.map(e -> e.key() + "=" + e.value())
			.collect(Collectors.joining("&"));
	}
	
	protected record QueryParam(String key, String value)
	{
	}
}
