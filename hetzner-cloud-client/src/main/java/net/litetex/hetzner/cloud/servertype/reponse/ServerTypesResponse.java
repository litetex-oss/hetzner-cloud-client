package net.litetex.hetzner.cloud.servertype.reponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public record ServerTypesResponse(
    @JsonProperty("server_types")
    List<ServerType> serverTypes)
{
}
