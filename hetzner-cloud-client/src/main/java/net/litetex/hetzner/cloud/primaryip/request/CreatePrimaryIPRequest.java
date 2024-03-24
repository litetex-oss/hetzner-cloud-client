package net.litetex.hetzner.cloud.primaryip.request;

import java.util.Map;
import java.util.Objects;

import jakarta.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.shared.IPAssigneeType;
import net.litetex.hetzner.cloud.support.NameLabelsBuilder;


public record CreatePrimaryIPRequest(
    @JsonProperty("assignee_id")
    Long assigneeId,
    @Nonnull
    @JsonProperty("assignee_type")
    String ipAssigneeType,
    @JsonProperty("auto_delete")
    Boolean autoDelete,
    String datacenter,
    Map<String, String> labels,
    @Nonnull
    String name,
    @Nonnull
    @JsonProperty("type")
    String ipType
)
{
    public CreatePrimaryIPRequest
    {
        Objects.requireNonNull(ipAssigneeType);
        Objects.requireNonNull(name);
        Objects.requireNonNull(ipType);
    }
    
    public static class Builder extends NameLabelsBuilder<Builder, CreatePrimaryIPRequest>
    {
        private Long assigneeId;
        private String ipAssigneeType = IPAssigneeType.SERVER;
        private Boolean autoDelete;
        private String datacenter;
        private String ipType;
        
        public Builder assigneeId(final Long assigneeId)
        {
            this.assigneeId = assigneeId;
            return this;
        }
        
        public Builder ipAssigneeType(final String ipAssigneeType)
        {
            this.ipAssigneeType = ipAssigneeType;
            return this;
        }
        
        public Builder autoDelete(final Boolean autoDelete)
        {
            this.autoDelete = autoDelete;
            return this;
        }
        
        public Builder datacenter(final String datacenter)
        {
            this.datacenter = datacenter;
            return this;
        }
        
        public Builder datacenter(final Long datacenter)
        {
            return this.datacenter(String.valueOf(datacenter));
        }
        
        public Builder ipType(final String ipType)
        {
            this.ipType = ipType;
            return this;
        }
        
        @Override
        public CreatePrimaryIPRequest build()
        {
            return new CreatePrimaryIPRequest(this.assigneeId,
                this.ipAssigneeType, this.autoDelete, this.datacenter, this.labels, this.name, this.ipType);
        }
    }
}
