package net.litetex.hetzner.cloud.certificate.response;

import java.util.List;

import net.litetex.hetzner.cloud.shared.Meta;


public record CertificatesResponse(
    List<Certificate> certificates,
    Meta meta
)
{
}
