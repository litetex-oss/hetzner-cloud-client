package net.litetex.hetzner.cloud.actions;

import java.util.function.Consumer;

import net.litetex.hetzner.cloud.RelativeUrlBuilder;
import net.litetex.hetzner.cloud.actions.request.ListActionsRequest;
import net.litetex.hetzner.cloud.actions.response.ActionResponse;
import net.litetex.hetzner.cloud.actions.response.ActionsResponse;
import net.litetex.hetzner.cloud.support.api.BaseAPI;


public interface ActionsAPI extends BaseAPI
{
	default ActionsResponse listActions()
	{
		return this.get("/actions", ActionsResponse.class);
	}
	
	default ActionsResponse listActions(final ListActionsRequest request)
	{
		return this.get(request.applyTo(new RelativeUrlBuilder("/actions")).build(), ActionsResponse.class);
	}
	
	default ActionsResponse listActions(final Consumer<ListActionsRequest> requestConsumer)
	{
		final ListActionsRequest request = new ListActionsRequest();
		requestConsumer.accept(request);
		return this.listActions(request);
	}
	
	default ActionResponse getAction(final long actionId)
	{
		return this.get("/actions/" + actionId, ActionResponse.class);
	}
	
	default ActionsResponse listActions(final long id)
	{
		return this.get("/" + id + "/actions", ActionsResponse.class);
	}
	
	default ActionsResponse listActions(final long id, final ListActionsRequest request)
	{
		return this.get(request.applyTo(new RelativeUrlBuilder("/" + id + "/actions")).build(), ActionsResponse.class);
	}
	
	default ActionsResponse listActions(final long id, final Consumer<ListActionsRequest> requestConsumer)
	{
		final ListActionsRequest request = new ListActionsRequest();
		requestConsumer.accept(request);
		return this.listActions(id, request);
	}
	
	default ActionResponse getAction(final long id, final long actionId)
	{
		return this.get("/" + id + "/actions/" + actionId, ActionResponse.class);
	}
}
