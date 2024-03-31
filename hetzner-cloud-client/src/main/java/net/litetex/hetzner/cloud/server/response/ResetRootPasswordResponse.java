package net.litetex.hetzner.cloud.server.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.actions.response.Action;


public record ResetRootPasswordResponse(
    Action action,
    @JsonProperty("root_password")
    String rootPassword
)
{
}
