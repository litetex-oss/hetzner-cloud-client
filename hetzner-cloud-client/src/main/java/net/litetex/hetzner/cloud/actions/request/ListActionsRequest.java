package net.litetex.hetzner.cloud.actions.request;

import java.util.ArrayList;
import java.util.List;

import net.litetex.hetzner.cloud.RelativeUrlBuilder;
import net.litetex.hetzner.cloud.list.request.ListRequest;


public class ListActionsRequest extends ListRequest<ListActionsRequest>
{
	protected List<Long> id = new ArrayList<>();
	protected List<String> status = new ArrayList<>();
	
	public ListActionsRequest id(final long id)
	{
		this.id.add(id);
		return this.self();
	}
	
	public ListActionsRequest status(final String status)
	{
		this.status.add(status);
		return this.self();
	}
	
	@Override
	public RelativeUrlBuilder applyTo(final RelativeUrlBuilder relativeUrlBuilder)
	{
		return super.applyTo(relativeUrlBuilder)
			.queryParams("id", this.id)
			.queryParams("status", this.status);
	}
}
