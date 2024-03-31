package net.litetex.hetzner.cloud.certificate.response;

import net.litetex.hetzner.cloud.actions.response.Action;
import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record CreateCertificateResponse(
	Action action,
	Certificate certificate
) implements SingleResponse<Certificate>
{
	@Override
	public Certificate data()
	{
		return this.certificate();
	}
}
