package net.litetex.hetzner.cloud.volume.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.IBuilder;


public record AttachVolumeRequest(
    @JsonProperty("server")
    long serverId,
    boolean automount
)
{
    public static class Builder implements IBuilder<AttachVolumeRequest>
    {
        private long serverId;
        private boolean automount;
        
        public Builder serverId(final long serverId)
        {
            this.serverId = serverId;
            return this;
        }
        
        public Builder automount(final boolean automount)
        {
            this.automount = automount;
            return this;
        }
        
        @Override
        public AttachVolumeRequest build()
        {
            return new AttachVolumeRequest(this.serverId, this.automount);
        }
    }
}
