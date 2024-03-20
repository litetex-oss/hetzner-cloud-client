package net.litetex.hetzner.cloud.server.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.actions.response.Action;


public record CreateServerResponse(
    Server server,
    Action action,
    @JsonProperty("next_actions")
    List<Action> nextActions,
    @JsonProperty("root_password")
    String rootPassword
)
{
}
