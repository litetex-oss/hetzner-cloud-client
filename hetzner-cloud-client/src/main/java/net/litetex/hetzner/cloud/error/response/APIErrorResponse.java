package net.litetex.hetzner.cloud.error.response;

import net.litetex.hetzner.cloud.objects.general.APIError;


public record APIErrorResponse(APIError error)
{
}
