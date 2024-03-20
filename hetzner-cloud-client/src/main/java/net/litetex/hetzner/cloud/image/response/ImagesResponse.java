package net.litetex.hetzner.cloud.image.response;

import java.util.List;

import net.litetex.hetzner.cloud.shared.Meta;


public record ImagesResponse(
    List<Image> images,
    Meta meta)
{
}
