package net.litetex.hetzner.cloud.volume.request;

import java.util.Map;
import java.util.Objects;

import jakarta.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.NameLabelsBuilder;


public record CreateVolumeRequest(
	@JsonProperty("size")
	long sizeInGB,
	@Nonnull
	String name,
	String location,
	boolean automount,
	String format,
	Long server,
	Map<String, String> labels
)
{
	public CreateVolumeRequest
	{
		Objects.requireNonNull(name);
	}
	
	public static class Builder extends NameLabelsBuilder<Builder, CreateVolumeRequest>
	{
		private long sizeInGB;
		private String location;
		private boolean automount;
		private String format;
		private Long server;
		
		public Builder sizeInGB(final long sizeInGB)
		{
			this.sizeInGB = sizeInGB;
			return this;
		}
		
		public Builder location(final String location)
		{
			this.location = location;
			return this;
		}
		
		public Builder automount(final boolean automount)
		{
			this.automount = automount;
			return this;
		}
		
		public Builder format(final String format)
		{
			this.format = format != null ? format.toLowerCase() : null;
			return this;
		}
		
		public Builder server(final Long server)
		{
			this.server = server;
			return this;
		}
		
		@Override
		public CreateVolumeRequest build()
		{
			return new CreateVolumeRequest(this.sizeInGB, this.name, this.location, this.automount,
				this.format, this.server, this.labels);
		}
	}
}
