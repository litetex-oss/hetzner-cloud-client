package net.litetex.hetzner.cloud.primaryip.request;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.NameLabelsBuilder;


public record UpdatePrimaryIPRequest(
    @JsonProperty("auto_delete")
    Boolean autoDelete,
    Map<String, String> labels,
    String name)
{
    
    public static class Builder extends NameLabelsBuilder<Builder, UpdatePrimaryIPRequest>
    {
        private Boolean autoDelete;
        
        public Builder autoDelete(final Boolean autoDelete)
        {
            this.autoDelete = autoDelete;
            return this;
        }
        
        @Override
        public UpdatePrimaryIPRequest build()
        {
            return new UpdatePrimaryIPRequest(this.autoDelete, this.labels, this.name);
        }
    }
}
