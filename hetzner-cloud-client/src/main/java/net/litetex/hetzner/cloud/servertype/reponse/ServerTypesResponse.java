package net.litetex.hetzner.cloud.servertype.reponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.list.response.ListResponse;


public record ServerTypesResponse(
    @JsonProperty("server_types")
    List<ServerType> serverTypes
) implements ListResponse<ServerType>
{
    @Override
    public List<ServerType> data()
    {
        return this.serverTypes();
    }
}
