package net.litetex.hetzner.cloud.list.request;

import java.util.ArrayList;
import java.util.List;

import net.litetex.hetzner.cloud.RelativeUrlBuilder;


public abstract class ListRequest<S>
{
	protected List<String> sort = new ArrayList<>();
	protected String name;
	protected String labelSelector;
	protected Long page;
	protected Long perPage;
	
	public S sort(final String sort)
	{
		this.sort.add(sort);
		return this.self();
	}
	
	public S name(final String name)
	{
		this.name = name;
		return this.self();
	}
	
	public S labelSelector(final String labelSelector)
	{
		this.labelSelector = labelSelector;
		return this.self();
	}
	
	public S page(final Long page)
	{
		this.page = page;
		return this.self();
	}
	
	public S page(final long page)
	{
		return this.page((Long)page);
	}
	
	public S perPage(final Long perPage)
	{
		this.perPage = perPage;
		return this.self();
	}
	
	public S perPage(final long perPage)
	{
		return this.perPage((Long)perPage);
	}
	
	public RelativeUrlBuilder applyTo(final RelativeUrlBuilder relativeUrlBuilder)
	{
		return relativeUrlBuilder
			.queryParams("sort", this.sort)
			.queryParam("name", this.name)
			.queryParam("label_selector", this.labelSelector)
			.queryParam("page", this.page)
			.queryParam("per_page", this.perPage);
	}
	
	@SuppressWarnings("unchecked")
	protected S self()
	{
		return (S)this;
	}
}
