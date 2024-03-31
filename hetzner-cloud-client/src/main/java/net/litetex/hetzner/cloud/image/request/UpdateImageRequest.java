package net.litetex.hetzner.cloud.image.request;

import java.util.Map;

import net.litetex.hetzner.cloud.support.LabelsBuilder;


public record UpdateImageRequest(
    String description,
    String type,
    Map<String, String> labels
)
{
    
    public static class Builder extends LabelsBuilder<Builder, UpdateImageRequest>
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
        public UpdateImageRequest build()
        {
            return new UpdateImageRequest(this.description, this.type, this.labels);
        }
    }
}
