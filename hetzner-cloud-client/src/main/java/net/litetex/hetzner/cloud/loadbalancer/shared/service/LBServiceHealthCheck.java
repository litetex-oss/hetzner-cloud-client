package net.litetex.hetzner.cloud.loadbalancer.shared.service;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import jakarta.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.BuilderUtil;
import net.litetex.hetzner.cloud.support.IBuilder;


public record LBServiceHealthCheck(
	Http http,
	int interval,
	int port,
	@Nonnull
	String protocol,
	int timeout,
	int retries
)
{
	public LBServiceHealthCheck
	{
		Objects.requireNonNull(protocol);
	}
	
	public record Http(
		@Nonnull
		String domain,
		@Nonnull
		String path,
		String response,
		@JsonProperty("status_codes")
		List<String> statusCodes,
		Boolean tls
	)
	{
		public Http
		{
			Objects.requireNonNull(domain);
			Objects.requireNonNull(path);
		}
		
		public static class Builder implements IBuilder<Http>
		{
			private String domain;
			private String path;
			private String response;
			private List<String> statusCodes;
			private Boolean tls;
			
			public Builder domain(final String domain)
			{
				this.domain = domain;
				return this;
			}
			
			public Builder path(final String path)
			{
				this.path = path;
				return this;
			}
			
			public Builder response(final String response)
			{
				this.response = response;
				return this;
			}
			
			public Builder statusCodes(final List<String> statusCodes)
			{
				this.statusCodes = statusCodes;
				return this;
			}
			
			public Builder tls(final Boolean tls)
			{
				this.tls = tls;
				return this;
			}
			
			@Override
			public Http build()
			{
				return new Http(
					this.domain,
					this.path,
					this.response,
					this.statusCodes,
					this.tls);
			}
		}
	}
	
	
	public static class Builder implements IBuilder<LBServiceHealthCheck>
	{
		private Http http;
		private int interval;
		private int port;
		private String protocol;
		private int timeout;
		private int retries;
		
		public Builder http(final Http http)
		{
			this.http = http;
			return this;
		}
		
		public Builder http(final Consumer<Http.Builder> builderConsumer)
		{
			return this.http(BuilderUtil.build(Http.Builder::new, builderConsumer));
		}
		
		public Builder interval(final int interval)
		{
			this.interval = interval;
			return this;
		}
		
		public Builder port(final int port)
		{
			this.port = port;
			return this;
		}
		
		public Builder protocol(final String protocol)
		{
			this.protocol = protocol;
			return this;
		}
		
		public Builder timeout(final int timeout)
		{
			this.timeout = timeout;
			return this;
		}
		
		public Builder retries(final int retries)
		{
			this.retries = retries;
			return this;
		}
		
		@Override
		public LBServiceHealthCheck build()
		{
			return new LBServiceHealthCheck(this.http, this.interval, this.port, this.protocol, this.timeout,
				this.retries);
		}
	}
}
