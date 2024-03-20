package net.litetex.hetzner.cloud.support;

import java.util.Map;


public record NameLabelsRequest(
	String name,
	Map<String, String> labels
)
{
	public static class Builder extends NameLabelsBuilder<Builder, NameLabelsRequest>
	{
		@Override
		public NameLabelsRequest build()
		{
			return new NameLabelsRequest(this.name, this.labels);
		}
	}
}
