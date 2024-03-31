package net.litetex.hetzner.cloud.certificate.response;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.HasID;


public record Certificate(
    long id,
    String name,
    Map<String, String> labels,
    String certificate,
    OffsetDateTime created,
    @JsonProperty("not_valid_before")
    OffsetDateTime notValidBefore,
    @JsonProperty("not_valid_after")
    OffsetDateTime notValidAfter,
    @JsonProperty("domain_names")
    List<String> domainNames,
    String fingerprint,
    @JsonProperty("used_by")
    List<CertificateUsers> usedBy,
    @JsonProperty("type")
    String certificateType
) implements HasID
{
    public record CertificateUsers(
        long id,
        String type
    )
    {
    }
}
