package net.litetex.hetzner.cloud.network.response;

import java.util.List;

import net.litetex.hetzner.cloud.shared.Meta;


public record NetworksResponse(
    List<Network> networks,
    Meta meta)
{
}
