package net.litetex.hetzner.cloud.floatingip.request;

import java.util.Map;

import net.litetex.hetzner.cloud.support.NameLabelsBuilder;


public record UpdateFloatingIPRequest(
    String name,
    String description,
    Map<String, String> labels
)
{
    public static class Builder extends NameLabelsBuilder<Builder, UpdateFloatingIPRequest>
    {
        private String description;
        
        public Builder description(final String description)
        {
            this.description = description;
            return this;
        }
        
        @Override
        public UpdateFloatingIPRequest build()
        {
            return new UpdateFloatingIPRequest(this.name, this.description, this.labels);
        }
    }
}
