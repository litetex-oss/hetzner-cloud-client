package net.litetex.hetzner.cloud.server.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.actions.response.Action;
import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record CreateServerResponse(
    Server server,
    Action action,
    @JsonProperty("next_actions")
    List<Action> nextActions,
    @JsonProperty("root_password")
    String rootPassword
) implements SingleResponse<Server>
{
    @Override
    public Server data()
    {
        return this.server();
    }
}
