package net.litetex.hetzner.cloud.certificate.response;

import java.util.List;

import net.litetex.hetzner.cloud.list.response.ListResponse;
import net.litetex.hetzner.cloud.shared.Meta;


public record CertificatesResponse(
    List<Certificate> certificates,
    Meta meta
) implements ListResponse<Certificate>
{
	@Override
	public List<Certificate> data()
	{
		return this.certificates();
	}
}
