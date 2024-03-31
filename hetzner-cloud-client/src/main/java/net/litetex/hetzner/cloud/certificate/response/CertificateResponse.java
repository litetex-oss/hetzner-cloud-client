package net.litetex.hetzner.cloud.certificate.response;

import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record CertificateResponse(
	Certificate certificate
) implements SingleResponse<Certificate>
{
	@Override
	public Certificate data()
	{
		return this.certificate();
	}
}
