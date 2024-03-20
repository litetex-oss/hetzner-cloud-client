package net.litetex.hetzner.cloud.floatingip.request;

import java.util.Map;
import java.util.Objects;

import jakarta.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.NameLabelsBuilder;


public record CreateFloatingIPRequest(
    @Nonnull
    @JsonProperty("type")
    String ipType,
    @JsonProperty("home_location")
    String homeLocation,
    Long server,
    String description,
    String name,
    Map<String, String> labels
)
{
    public CreateFloatingIPRequest
    {
        Objects.requireNonNull(ipType);
    }
    
    public static class Builder extends NameLabelsBuilder<Builder, CreateFloatingIPRequest>
    {
        private String ipType;
        private String homeLocation;
        private Long server;
        private String description;
        
        public Builder ipType(final String ipType)
        {
            this.ipType = ipType;
            return this;
        }
        
        public Builder homeLocation(final String homeLocation)
        {
            this.homeLocation = homeLocation;
            return this;
        }
        
        public Builder server(final Long server)
        {
            this.server = server;
            return this;
        }
        
        public Builder description(final String description)
        {
            this.description = description;
            return this;
        }
        
        @Override
        public CreateFloatingIPRequest build()
        {
            return new CreateFloatingIPRequest(this.ipType, this.homeLocation, this.server,
                this.description, this.name, this.labels);
        }
    }
}
