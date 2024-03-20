package net.litetex.hetzner.cloud.loadbalancer.shared.service;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.IBuilder;


public record LBServiceHttp(
	List<Long> certificates,
	@JsonProperty("cookie_lifetime")
	Long cookieLifetime,
	@JsonProperty("cookie_name")
	String cookieName,
	@JsonProperty("redirect_http")
	Boolean redirectHttp,
	@JsonProperty("sticky_sessions")
	Boolean stickySessions
)
{
	public static class Builder implements IBuilder<LBServiceHttp>
	{
		private List<Long> certificates;
		private Long cookieLifetime;
		private String cookieName;
		private Boolean redirectHttp;
		private Boolean stickySessions;
		
		public Builder certificates(final List<Long> certificates)
		{
			this.certificates = certificates;
			return this;
		}
		
		public Builder certificate(final long certificate)
		{
			if(this.certificates == null)
			{
				this.certificates = new ArrayList<>();
			}
			this.certificates.add(certificate);
			return this;
		}
		
		public Builder cookieLifetime(final Long cookieLifetime)
		{
			this.cookieLifetime = cookieLifetime;
			return this;
		}
		
		public Builder cookieName(final String cookieName)
		{
			this.cookieName = cookieName;
			return this;
		}
		
		public Builder redirectHttp(final Boolean redirectHttp)
		{
			this.redirectHttp = redirectHttp;
			return this;
		}
		
		public Builder stickySessions(final Boolean stickySessions)
		{
			this.stickySessions = stickySessions;
			return this;
		}
		
		@Override
		public LBServiceHttp build()
		{
			return new LBServiceHttp(this.certificates, this.cookieLifetime,
				this.cookieName, this.redirectHttp, this.stickySessions);
		}
	}
}
