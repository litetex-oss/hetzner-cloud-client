package net.litetex.hetzner.cloud.loadbalancer.request;

import java.util.Objects;
import java.util.Optional;

import jakarta.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.loadbalancer.shared.target.LBTarget;
import net.litetex.hetzner.cloud.loadbalancer.shared.target.LBTargetIP;
import net.litetex.hetzner.cloud.loadbalancer.shared.target.LBTargetLabelSelector;
import net.litetex.hetzner.cloud.loadbalancer.shared.target.LBTargetServer;
import net.litetex.hetzner.cloud.loadbalancer.shared.target.LBTargetType;
import net.litetex.hetzner.cloud.support.IBuilder;


/**
 * @see LBTarget
 */
public record LoadBalancerTargetRequest(
	@JsonProperty("ip")
	LBTargetIP ip,
	@JsonProperty("label_selector")
	LBTargetLabelSelector labelSelector,
	@JsonProperty("server")
	LBTargetServer server,
	@JsonProperty("type")
	@Nonnull
	String targetType,
	@JsonProperty("use_private_ip")
	Boolean usePrivateIp
)
{
	public LoadBalancerTargetRequest
	{
		Objects.requireNonNull(targetType);
	}
	
	public static class Builder implements IBuilder<LoadBalancerTargetRequest>
	{
		private LBTargetIP ip;
		private LBTargetLabelSelector labelSelector;
		private LBTargetServer server;
		private String targetType;
		private Boolean usePrivateIp;
		
		public Builder ip(final LBTargetIP ip)
		{
			this.ip = ip;
			return this;
		}
		
		public Builder ip(final String ip)
		{
			return this.ip(new LBTargetIP(ip));
		}
		
		public Builder labelSelector(final LBTargetLabelSelector labelSelector)
		{
			this.labelSelector = labelSelector;
			return this;
		}
		
		public Builder labelSelector(final String labelSelector)
		{
			return this.labelSelector(new LBTargetLabelSelector(labelSelector));
		}
		
		public Builder server(final LBTargetServer server)
		{
			this.server = server;
			return this;
		}
		
		public Builder server(final long serverId)
		{
			return this.server(new LBTargetServer(serverId));
		}
		
		public Builder targetType(final String targetType)
		{
			this.targetType = targetType;
			return this;
		}
		
		public Builder usePrivateIp(final Boolean usePrivateIp)
		{
			this.usePrivateIp = usePrivateIp;
			return this;
		}
		
		@Override
		public LoadBalancerTargetRequest build()
		{
			return new LoadBalancerTargetRequest(
				this.ip,
				this.labelSelector,
				this.server,
				Optional.ofNullable(this.targetType)
					.orElseGet(() -> {
						if(this.server != null)
						{
							return LBTargetType.SERVER;
						}
						if(this.ip != null)
						{
							return LBTargetType.IP;
						}
						if(this.labelSelector != null)
						{
							return LBTargetType.LABEL_SELECTOR;
						}
						throw new IllegalStateException("Unable to determine targetType automatically");
					}),
				this.usePrivateIp);
		}
	}
}
