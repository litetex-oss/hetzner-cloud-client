package net.litetex.hetzner.cloud.primaryip.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.shared.IPAssigneeType;
import net.litetex.hetzner.cloud.support.IBuilder;


public record AssignPrimaryIPRequest(
    @JsonProperty("assignee_id")
    long assigneeId,
    @JsonProperty("assignee_type")
    String ipAssigneeType)
{
    
    public static class Builder implements IBuilder<AssignPrimaryIPRequest>
    {
        private long assigneeId;
        private String ipAssigneeType = IPAssigneeType.SERVER;
        
        public Builder assigneeId(final long assigneeId)
        {
            this.assigneeId = assigneeId;
            return this;
        }
        
        public Builder ipAssigneeType(final String ipAssigneeType)
        {
            this.ipAssigneeType = ipAssigneeType;
            return this;
        }
        
        @Override
        public AssignPrimaryIPRequest build()
        {
            return new AssignPrimaryIPRequest(this.assigneeId, this.ipAssigneeType);
        }
    }
}
