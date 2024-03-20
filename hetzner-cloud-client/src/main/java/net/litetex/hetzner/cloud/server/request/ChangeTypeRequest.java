package net.litetex.hetzner.cloud.server.request;

import java.util.Objects;

import jakarta.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.IBuilder;


public record ChangeTypeRequest(
    @JsonProperty("upgrade_disk")
    boolean upgradeDisk,
    @Nonnull
    @JsonProperty("server_type")
    String serverType
)
{
    public ChangeTypeRequest
    {
        Objects.requireNonNull(serverType);
    }
    
    public static class Builder implements IBuilder<ChangeTypeRequest>
    {
        private boolean upgradeDisk;
        private String serverType;
        
        public Builder upgradeDisk(final boolean upgradeDisk)
        {
            this.upgradeDisk = upgradeDisk;
            return this;
        }
        
        public Builder serverType(final String serverType)
        {
            this.serverType = serverType;
            return this;
        }
        
        @Override
        public ChangeTypeRequest build()
        {
            return new ChangeTypeRequest(this.upgradeDisk, this.serverType);
        }
    }
}
