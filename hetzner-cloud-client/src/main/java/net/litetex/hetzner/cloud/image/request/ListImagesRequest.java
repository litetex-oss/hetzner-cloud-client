package net.litetex.hetzner.cloud.image.request;

import java.util.ArrayList;
import java.util.List;

import net.litetex.hetzner.cloud.RelativeUrlBuilder;
import net.litetex.hetzner.cloud.list.request.ListRequest;


public class ListImagesRequest extends ListRequest<ListImagesRequest>
{
	protected List<String> type = new ArrayList<>();
	protected List<String> status = new ArrayList<>();
	protected List<String> boundTo = new ArrayList<>();
	protected Boolean includeDeprecated;
	protected String architecture;
	
	public ListImagesRequest type(final String type)
	{
		this.type.add(type);
		return this.self();
	}
	
	public ListImagesRequest status(final String status)
	{
		this.status.add(status);
		return this.self();
	}
	
	public ListImagesRequest boundTo(final String boundTo)
	{
		this.boundTo.add(boundTo);
		return this.self();
	}
	
	public ListImagesRequest includeDeprecated(final Boolean includeDeprecated)
	{
		this.includeDeprecated = includeDeprecated;
		return this.self();
	}
	
	public ListImagesRequest architecture(final String architecture)
	{
		this.architecture = architecture;
		return this.self();
	}
	
	@Override
	public RelativeUrlBuilder applyTo(final RelativeUrlBuilder relativeUrlBuilder)
	{
		return super.applyTo(relativeUrlBuilder)
			.queryParams("type", this.type)
			.queryParams("status", this.status)
			.queryParams("bound_to", this.boundTo)
			.queryParam("include_deprecated", this.includeDeprecated)
			.queryParam("architecture", this.architecture);
	}
}
