package net.litetex.hetzner.cloud.actions.response;

import java.util.List;

import net.litetex.hetzner.cloud.list.response.ListResponse;
import net.litetex.hetzner.cloud.shared.Meta;


public record ActionsResponse(
	List<Action> actions,
	Meta meta
) implements ListResponse<Action>
{
	@Override
	public List<Action> data()
	{
		return this.actions();
	}
}
