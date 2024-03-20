package net.litetex.hetzner.cloud.protection.request;

import com.fasterxml.jackson.annotation.JsonInclude;

import net.litetex.hetzner.cloud.support.IBuilder;


public record ChangeProtectionRequest(
    Boolean delete,
    Boolean rebuild
)
{
    public static class Builder implements IBuilder<ChangeProtectionRequest>
    {
        private Boolean delete;
        private Boolean rebuild;
        
        public Builder()
        {
        }
        
        public Builder delete(final Boolean delete)
        {
            this.delete = delete;
            return this;
        }
        
        public Builder rebuild(final Boolean rebuild)
        {
            this.rebuild = rebuild;
            return this;
        }
        
        @Override
        public ChangeProtectionRequest build()
        {
            return new ChangeProtectionRequest(this.delete, this.rebuild);
        }
    }
}
