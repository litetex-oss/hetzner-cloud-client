package net.litetex.hetzner.cloud.support.api;

public interface BaseAPI
{
	<T> T get(final String path, final Class<T> clazz);
	
	<T> T delete(final String path, final Class<T> clazz);
	
	<T> T put(final String path, final Object body, final Class<T> clazz);
	
	<T> T post(final String path, final Object body, final Class<T> clazz);
	
	<T> T post(final String path, final Class<T> clazz);
}
