package net.litetex.hetzner.cloud.loadbalancer.shared.service;

import java.util.Objects;
import java.util.function.Consumer;

import jakarta.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.BuilderUtil;
import net.litetex.hetzner.cloud.support.IBuilder;


public record LBService(
	@JsonProperty("destination_port")
	int destinationPort,
	@JsonProperty("health_check")
	@Nonnull
	LBServiceHealthCheck healthCheck,
	LBServiceHttp http,
	@Nonnull
	String protocol,
	@JsonProperty("listen_port")
	int listenPort,
	@JsonProperty("proxyprotocol")
	boolean proxyProtocol
)
{
	public LBService
	{
		Objects.requireNonNull(healthCheck);
		Objects.requireNonNull(protocol);
	}
	
	public static class Builder implements IBuilder<LBService>
	{
		private int destinationPort;
		private LBServiceHealthCheck healthCheck;
		private LBServiceHttp http;
		private String protocol;
		private int listenPort;
		private boolean proxyProtocol;
		
		public Builder destinationPort(final int destinationPort)
		{
			this.destinationPort = destinationPort;
			return this;
		}
		
		public Builder healthCheck(final LBServiceHealthCheck healthCheck)
		{
			this.healthCheck = healthCheck;
			return this;
		}
		
		public Builder healthCheck(final Consumer<LBServiceHealthCheck.Builder> builderConsumer)
		{
			return this.healthCheck(BuilderUtil.build(LBServiceHealthCheck.Builder::new, builderConsumer));
		}
		
		public Builder http(final LBServiceHttp http)
		{
			this.http = http;
			return this;
		}
		
		public Builder http(final Consumer<LBServiceHttp.Builder> builderConsumer)
		{
			return this.http(BuilderUtil.build(LBServiceHttp.Builder::new, builderConsumer));
		}
		
		public Builder protocol(final String protocol)
		{
			this.protocol = protocol;
			return this;
		}
		
		public Builder listenPort(final int listenPort)
		{
			this.listenPort = listenPort;
			return this;
		}
		
		public Builder proxyProtocol(final boolean proxyProtocol)
		{
			this.proxyProtocol = proxyProtocol;
			return this;
		}
		
		@Override
		public LBService build()
		{
			return new LBService(this.destinationPort, this.healthCheck, this.http,
				this.protocol, this.listenPort, this.proxyProtocol);
		}
	}
}
