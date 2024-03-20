package net.litetex.hetzner.cloud.support;

import java.util.HashMap;
import java.util.Map;


public abstract class LabelsBuilder<S extends LabelsBuilder<S, T>, T>
	implements IBuilder<T>
{
	protected Map<String, String> labels;
	
	public S labels(final Map<String, String> labels)
	{
		this.labels = labels;
		return this.self();
	}
	
	public S label(final String key, final String value)
	{
		if(this.labels == null)
		{
			this.labels = new HashMap<>();
		}
		this.labels.put(key, value);
		return this.self();
	}
	
	@SuppressWarnings("unchecked")
	protected S self()
	{
		return (S)this;
	}
}
