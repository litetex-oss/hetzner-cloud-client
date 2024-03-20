package net.litetex.hetzner.cloud.actions;

import net.litetex.hetzner.cloud.actions.response.ActionResponse;
import net.litetex.hetzner.cloud.actions.response.ActionsResponse;
import net.litetex.hetzner.cloud.support.api.BaseAPI;


public interface ActionsAPI extends BaseAPI
{
	default ActionsResponse listActions()
	{
		return this.get("/actions", ActionsResponse.class);
	}
	
	default ActionResponse getAction(final long actionId)
	{
		return this.get("/actions/" + actionId, ActionResponse.class);
	}
	
	default ActionsResponse listActions(final long id)
	{
		return this.get("/" + id + "/actions", ActionsResponse.class);
	}
	
	default ActionResponse getAction(final long id, final long actionId)
	{
		return this.get("/" + id + "/actions/" + actionId, ActionResponse.class);
	}
}
