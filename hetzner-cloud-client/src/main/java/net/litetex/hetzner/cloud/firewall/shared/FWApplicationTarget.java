package net.litetex.hetzner.cloud.firewall.shared;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.shared.TargetType;


public record FWApplicationTarget(
	@JsonProperty("label_selector")
	FWLabelSelector labelSelector,
	FWServerRef server,
	@JsonProperty("type")
	String targetType
)
{
	public static class Builder
	{
		private FWLabelSelector labelSelector;
		private FWServerRef server;
		
		public Builder()
		{
		}
		
		public Builder labelSelector(final String labelSelector)
		{
			this.labelSelector = new FWLabelSelector(labelSelector);
			return this;
		}
		
		public Builder labelSelector(final FWLabelSelector labelSelector)
		{
			this.labelSelector = labelSelector;
			return this;
		}
		
		public Builder server(final long id)
		{
			this.server = new FWServerRef(id);
			return this;
		}
		
		public Builder server(final FWServerRef server)
		{
			this.server = server;
			return this;
		}
		
		public FWApplicationTarget build()
		{
			return new FWApplicationTarget(
				this.labelSelector,
				this.server,
				this.server != null ? TargetType.LABEL_SELECTOR : TargetType.SERVER);
		}
	}
}
