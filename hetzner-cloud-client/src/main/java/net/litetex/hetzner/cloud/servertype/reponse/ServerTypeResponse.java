package net.litetex.hetzner.cloud.servertype.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record ServerTypeResponse(
    @JsonProperty("server_type")
    ServerType serverType
) implements SingleResponse<ServerType>
{
    @Override
    public ServerType data()
    {
        return this.serverType();
    }
}
