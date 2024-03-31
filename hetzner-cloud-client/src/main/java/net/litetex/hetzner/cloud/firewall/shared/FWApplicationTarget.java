package net.litetex.hetzner.cloud.firewall.shared;

import java.util.Objects;

import jakarta.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.shared.TargetType;
import net.litetex.hetzner.cloud.support.IBuilder;


public record FWApplicationTarget(
	@JsonProperty("label_selector")
	FWLabelSelector labelSelector,
	FWServerRef server,
	@Nonnull
	@JsonProperty("type")
	String targetType
)
{
	public FWApplicationTarget
	{
		Objects.requireNonNull(targetType);
	}
	
	public static class Builder implements IBuilder<FWApplicationTarget>
	{
		private FWLabelSelector labelSelector;
		private FWServerRef server;
		
		public Builder labelSelector(final FWLabelSelector labelSelector)
		{
			this.labelSelector = labelSelector;
			return this;
		}
		
		public Builder labelSelector(final String selector)
		{
			return this.labelSelector(new FWLabelSelector(selector));
		}
		
		public Builder server(final FWServerRef server)
		{
			this.server = server;
			return this;
		}
		
		public Builder server(final long id)
		{
			return this.server(new FWServerRef(id));
		}
		
		@Override
		public FWApplicationTarget build()
		{
			return new FWApplicationTarget(
				this.labelSelector,
				this.server,
				this.server != null ? TargetType.LABEL_SELECTOR : TargetType.SERVER);
		}
	}
}
