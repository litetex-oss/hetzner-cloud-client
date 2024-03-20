package net.litetex.hetzner.cloud.server.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.actions.response.Action;


public record ConsoleResponse(
    @JsonProperty("wss_url")
    String wssURL,
    String password,
    Action action)
{
}
