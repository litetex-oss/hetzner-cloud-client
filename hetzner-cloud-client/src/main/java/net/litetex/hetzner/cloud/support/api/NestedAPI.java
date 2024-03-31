package net.litetex.hetzner.cloud.support.api;

import java.util.function.Consumer;
import java.util.function.Supplier;

import net.litetex.hetzner.cloud.support.BuilderUtil;
import net.litetex.hetzner.cloud.support.IBuilder;


public abstract class NestedAPI implements BaseAPI
{
	protected final BaseAPI parentAPI;
	
	protected final String pathPrefix;
	
	protected NestedAPI(final BaseAPI parentAPI, final String pathPrefix)
	{
		this.parentAPI = parentAPI;
		this.pathPrefix = pathPrefix;
	}
	
	@Override
	public <T> T get(final String path, final Class<T> clazz)
	{
		return this.parentAPI.get(this.pathPrefix + path, clazz);
	}
	
	@Override
	public <T> T delete(final String path, final Class<T> clazz)
	{
		return this.parentAPI.delete(this.pathPrefix + path, clazz);
	}
	
	@Override
	public <T> T put(final String path, final Object body, final Class<T> clazz)
	{
		return this.parentAPI.put(this.pathPrefix + path, body, clazz);
	}
	
	@Override
	public <T> T post(final String path, final Object body, final Class<T> clazz)
	{
		return this.parentAPI.post(this.pathPrefix + path, body, clazz);
	}
	
	@Override
	public <T> T post(final String path, final Class<T> clazz)
	{
		return this.parentAPI.post(this.pathPrefix + path, clazz);
	}
	
	protected <B extends IBuilder<T>, T> T build(
		final Supplier<B> builderSupplier,
		final Consumer<B> builderConsumer)
	{
		return BuilderUtil.build(builderSupplier, builderConsumer);
	}
}
