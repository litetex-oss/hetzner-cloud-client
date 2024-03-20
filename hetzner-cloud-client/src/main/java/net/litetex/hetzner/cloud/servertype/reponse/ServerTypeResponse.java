package net.litetex.hetzner.cloud.servertype.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;


public record ServerTypeResponse(
    @JsonProperty("server_type")
    ServerType serverType)
{
}
