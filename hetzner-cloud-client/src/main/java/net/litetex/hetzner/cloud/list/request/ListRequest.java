package net.litetex.hetzner.cloud.list.request;

import net.litetex.hetzner.cloud.RelativeUrlBuilder;


public abstract class ListRequest<S>
{
	protected String sort;
	protected String name;
	protected String labelSelector;
	protected Integer page;
	protected Integer perPage;
	
	public S sort(final String sort)
	{
		this.sort = sort;
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
	
	public S page(final Integer page)
	{
		this.page = page;
		return this.self();
	}
	
	public S perPage(final Integer perPage)
	{
		this.perPage = perPage;
		return this.self();
	}
	
	public RelativeUrlBuilder applyTo(final RelativeUrlBuilder relativeUrlBuilder)
	{
		return relativeUrlBuilder
			.queryParam("sort", this.sort)
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
