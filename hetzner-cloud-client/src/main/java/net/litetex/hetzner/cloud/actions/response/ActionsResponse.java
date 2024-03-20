package net.litetex.hetzner.cloud.actions.response;

import java.util.List;

import net.litetex.hetzner.cloud.shared.Meta;


public record ActionsResponse(
	List<Action> actions,
	Meta meta)
{
}
