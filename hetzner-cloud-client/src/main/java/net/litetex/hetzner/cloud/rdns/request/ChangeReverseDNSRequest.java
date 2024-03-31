package net.litetex.hetzner.cloud.rdns.request;

import java.util.Objects;

import jakarta.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.IBuilder;


public record ChangeReverseDNSRequest(
	@Nonnull
	String ip,
	@JsonInclude // Can be nullable
	@JsonProperty("dns_ptr")
	String dnsPTR)
{
	public ChangeReverseDNSRequest
	{
		Objects.requireNonNull(ip);
	}
	
	public static class Builder implements IBuilder<ChangeReverseDNSRequest>
	{
		private String ip;
		private String dnsPTR;
		
		public Builder ip(final String ip)
		{
			this.ip = ip;
			return this;
		}
		
		public Builder dnsPTR(final String dnsPTR)
		{
			this.dnsPTR = dnsPTR;
			return this;
		}
		
		@Override
		public ChangeReverseDNSRequest build()
		{
			return new ChangeReverseDNSRequest(this.ip, this.dnsPTR);
		}
	}
}
