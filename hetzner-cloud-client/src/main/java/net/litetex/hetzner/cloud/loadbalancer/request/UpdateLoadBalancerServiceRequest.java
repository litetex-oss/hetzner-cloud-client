package net.litetex.hetzner.cloud.loadbalancer.request;

import java.util.function.Consumer;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.loadbalancer.shared.service.LBServiceHealthCheck;
import net.litetex.hetzner.cloud.loadbalancer.shared.service.LBServiceHttp;
import net.litetex.hetzner.cloud.support.BuilderUtil;
import net.litetex.hetzner.cloud.support.IBuilder;


/**
 * @see net.litetex.hetzner.cloud.loadbalancer.shared.service.LBService
 */
public record UpdateLoadBalancerServiceRequest(
	@JsonProperty("destination_port")
	Integer destinationPort,
	@JsonProperty("health_check")
	LBServiceHealthCheck healthCheck,
	LBServiceHttp http,
	String protocol,
	@JsonProperty("listen_port")
	int listenPort,
	@JsonProperty("proxyprotocol")
	Boolean proxyProtocol
)
{
	public static class Builder implements IBuilder<UpdateLoadBalancerServiceRequest>
	{
		private Integer destinationPort;
		private LBServiceHealthCheck healthCheck;
		private LBServiceHttp http;
		private String protocol;
		private int listenPort;
		private Boolean proxyProtocol;
		
		public Builder destinationPort(final Integer destinationPort)
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
		
		public Builder proxyProtocol(final Boolean proxyProtocol)
		{
			this.proxyProtocol = proxyProtocol;
			return this;
		}
		
		@Override
		public UpdateLoadBalancerServiceRequest build()
		{
			return new UpdateLoadBalancerServiceRequest(this.destinationPort, this.healthCheck, this.http,
				this.protocol, this.listenPort, this.proxyProtocol);
		}
	}
}
