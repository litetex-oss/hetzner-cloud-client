package net.litetex.hetzner.cloud.server.response;

import java.util.List;

import net.litetex.hetzner.cloud.shared.Meta;


public record ServersResponse(
    List<Server> server,
    Meta meta)
{
}
