package net.litetex.hetzner.cloud.certificate.response;

import net.litetex.hetzner.cloud.actions.response.Action;


public record CreateCertificateResponse(
	Action action,
	Certificate certificate)
{
}
