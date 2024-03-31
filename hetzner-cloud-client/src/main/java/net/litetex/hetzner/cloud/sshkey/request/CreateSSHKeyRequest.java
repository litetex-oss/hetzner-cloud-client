package net.litetex.hetzner.cloud.sshkey.request;

import java.util.Map;
import java.util.Objects;

import jakarta.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.NameLabelsBuilder;


public record CreateSSHKeyRequest(
    @Nonnull
    String name,
    @Nonnull
    @JsonProperty("public_key")
    String publicKey,
    Map<String, String> labels,
    @JsonProperty("is_default")
    Boolean isDefault
)
{
    public CreateSSHKeyRequest
    {
        Objects.requireNonNull(name);
        Objects.requireNonNull(publicKey);
    }
    
    public static class Builder extends NameLabelsBuilder<Builder, CreateSSHKeyRequest>
    {
        private String publicKey;
        
        private Boolean isDefault;
        
        public Builder publicKey(final String publicKey)
        {
            this.publicKey = publicKey;
            return this;
        }
        
        public Builder isDefault(final Boolean isDefault)
        {
            this.isDefault = isDefault;
            return this;
        }
        
        @Override
        public CreateSSHKeyRequest build()
        {
            return new CreateSSHKeyRequest(this.name, this.publicKey, this.labels, this.isDefault);
        }
    }
}
