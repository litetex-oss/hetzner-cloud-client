package net.litetex.hetzner.cloud.sshkey.request;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.NameLabelsBuilder;


public record UpdateSSHKeyRequest(
	String name,
	Map<String, String> labels,
	@JsonProperty("is_default")
	Boolean isDefault
)
{
	public static class Builder extends NameLabelsBuilder<Builder, UpdateSSHKeyRequest>
	{
		private Boolean isDefault;
		
		public Builder isDefault(final Boolean isDefault)
		{
			this.isDefault = isDefault;
			return this;
		}
		
		@Override
		public UpdateSSHKeyRequest build()
		{
			return new UpdateSSHKeyRequest(this.name, this.labels, this.isDefault);
		}
	}
}
