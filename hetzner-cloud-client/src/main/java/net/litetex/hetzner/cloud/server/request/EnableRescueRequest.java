package net.litetex.hetzner.cloud.server.request;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.IBuilder;


public record EnableRescueRequest(
    String type,
    @JsonProperty("ssh_keys")
    List<Long> sshKeys
)
{
    public static class Builder implements IBuilder<EnableRescueRequest>
    {
        private String type;
        private List<Long> sshKeys = new ArrayList<>();
        
        public Builder type(final String type)
        {
            this.type = type;
            return this;
        }
        
        public Builder sshKeys(final List<Long> sshKeys)
        {
            this.sshKeys = sshKeys;
            return this;
        }
        
        public Builder sshKey(final long sshKeyId)
        {
            if(this.sshKeys == null)
            {
				this.sshKeys = new ArrayList<>();
            }
            this.sshKeys.add(sshKeyId);
            return this;
        }
        
        @Override
        public EnableRescueRequest build()
        {
            return new EnableRescueRequest(this.type, this.sshKeys);
        }
    }
}
