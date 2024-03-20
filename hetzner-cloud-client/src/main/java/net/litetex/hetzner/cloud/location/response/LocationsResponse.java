package net.litetex.hetzner.cloud.location.response;

import java.util.List;


public record LocationsResponse(
    List<Location> locations)
{
}
