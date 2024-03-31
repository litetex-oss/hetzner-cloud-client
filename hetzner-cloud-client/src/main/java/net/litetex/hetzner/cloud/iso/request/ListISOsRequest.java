package net.litetex.hetzner.cloud.iso.request;

import net.litetex.hetzner.cloud.RelativeUrlBuilder;
import net.litetex.hetzner.cloud.list.request.ListRequest;


public class ListISOsRequest extends ListRequest<ListISOsRequest>
{
	protected String architecture;
	protected Boolean includeArchitectureWildcard;
	
	public ListISOsRequest architecture(final String architecture)
	{
		this.architecture = architecture;
		return this.self();
	}
	
	public ListISOsRequest includeArchitectureWildcard(final Boolean includeArchitectureWildcard)
	{
		this.includeArchitectureWildcard = includeArchitectureWildcard;
		return this.self();
	}
	
	@Override
	public RelativeUrlBuilder applyTo(final RelativeUrlBuilder relativeUrlBuilder)
	{
		return super.applyTo(relativeUrlBuilder)
			.queryParam("architecture", this.architecture)
			.queryParam("include_architecture_wildcard", this.includeArchitectureWildcard);
	}
}
