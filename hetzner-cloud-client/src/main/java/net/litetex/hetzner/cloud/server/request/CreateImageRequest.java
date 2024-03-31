package net.litetex.hetzner.cloud.server.request;

import java.util.Map;

import net.litetex.hetzner.cloud.support.LabelsBuilder;


public record CreateImageRequest(
    String description,
    String type,
    Map<String, String> labels
)
{
    public static class Builder extends LabelsBuilder<Builder, CreateImageRequest>
    {
        private String description;
        private String type;
        
        public Builder description(final String description)
        {
            this.description = description;
            return this;
        }
        
        public Builder type(final String type)
        {
            this.type = type;
            return this;
        }
        
        @Override
        public CreateImageRequest build()
        {
            return new CreateImageRequest(this.description, this.type, this.labels);
        }
    }
}
