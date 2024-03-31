package net.litetex.hetzner.cloud.support.api;

public interface DeleteAPI extends BaseAPI
{
	default String delete(final long id)
	{
		return this.delete("/" + id, String.class);
	}
}
