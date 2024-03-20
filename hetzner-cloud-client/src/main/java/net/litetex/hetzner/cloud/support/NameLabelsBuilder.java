package net.litetex.hetzner.cloud.support;

public abstract class NameLabelsBuilder<S extends NameLabelsBuilder<S, T>, T>
	extends LabelsBuilder<S, T>
	implements IBuilder<T>
{
	protected String name;
	
	public S name(final String name)
	{
		this.name = name;
		return this.self();
	}
}
