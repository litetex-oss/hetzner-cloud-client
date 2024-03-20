package net.litetex.hetzner.cloud.image.request;

import net.litetex.hetzner.cloud.RelativeUrlBuilder;
import net.litetex.hetzner.cloud.list.request.ListRequest;


public class ListImagesRequest extends ListRequest<ListImagesRequest>
{
	protected String type;
	protected String status;
	protected String boundTo;
	protected Boolean includeDeprecated;
	protected String architecture;
	
	public ListImagesRequest type(final String type)
	{
		this.type = type;
		return this.self();
	}
	
	public ListImagesRequest status(final String status)
	{
		this.status = status;
		return this.self();
	}
	
	public ListImagesRequest boundTo(final String boundTo)
	{
		this.boundTo = boundTo;
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
			.queryParam("type", this.type)
			.queryParam("status", this.status)
			.queryParam("bound_to", this.boundTo)
			.queryParam("include_deprecated", this.includeDeprecated)
			.queryParam("architecture", this.architecture);
	}
}
