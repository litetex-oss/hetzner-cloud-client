package net.litetex.hetzner.cloud.certificate.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import jakarta.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.NameLabelsBuilder;


public record CreateCertificateRequest(
    @Nonnull
    String name,
    String certificate,
    @JsonProperty("domain_names")
    List<String> domainNames,
    @JsonProperty("private_key")
    String privateKey,
    Map<String, String> labels,
    @JsonProperty("type")
    String certificateType
)
{
    public CreateCertificateRequest
    {
        Objects.requireNonNull(name);
    }
    
    public static class Builder extends NameLabelsBuilder<Builder, CreateCertificateRequest>
    {
        private String certificate;
        private List<String> domainNames;
        private String privateKey;
        private String certificateType;
        
        public Builder certificate(final String certificate)
        {
            this.certificate = certificate;
            return this;
        }
        
        public Builder domainNames(final List<String> domainNames)
        {
            this.domainNames = domainNames;
            return this;
        }
        
        public Builder domainName(final String domainName)
        {
            if(this.domainNames == null)
            {
                this.domainNames = new ArrayList<>();
            }
            this.domainNames.add(domainName);
            return this;
        }
        
        public Builder privateKey(final String privateKey)
        {
            this.privateKey = privateKey;
            return this;
        }
        
        public Builder certificateType(final String certificateType)
        {
            this.certificateType = certificateType;
            return this;
        }
        
        @Override
        public CreateCertificateRequest build()
        {
            return new CreateCertificateRequest(this.name,
				this.certificate, this.domainNames, this.privateKey, this.labels, this.certificateType);
        }
    }
}
