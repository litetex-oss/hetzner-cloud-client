package net.litetex.hetzner.cloud.server.request;

import java.util.ArrayList;
import java.util.List;

import net.litetex.hetzner.cloud.RelativeUrlBuilder;
import net.litetex.hetzner.cloud.list.request.ListRequest;


public class ListServersRequest extends ListRequest<ListServersRequest>
{
	protected List<String> status = new ArrayList<>();
	
	public ListServersRequest status(final String status)
	{
		this.status.add(status);
		return this.self();
	}
	
	@Override
	public RelativeUrlBuilder applyTo(final RelativeUrlBuilder relativeUrlBuilder)
	{
		return super.applyTo(relativeUrlBuilder)
			.queryParams("status", this.status);
	}
}
