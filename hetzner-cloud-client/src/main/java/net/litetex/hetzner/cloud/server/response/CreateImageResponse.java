package net.litetex.hetzner.cloud.server.response;

import net.litetex.hetzner.cloud.actions.response.Action;
import net.litetex.hetzner.cloud.image.response.Image;


public record CreateImageResponse(
    Image image,
    Action action)
{
}
