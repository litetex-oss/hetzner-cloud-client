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
    Map<String, String> labels
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
        
        public Builder publicKey(final String publicKey)
        {
            this.publicKey = publicKey;
            return this;
        }
        
        @Override
        public CreateSSHKeyRequest build()
        {
            return new CreateSSHKeyRequest(this.name, this.publicKey, this.labels);
        }
    }
}
