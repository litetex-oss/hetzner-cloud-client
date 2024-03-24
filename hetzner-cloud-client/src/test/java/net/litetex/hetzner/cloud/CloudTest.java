package net.litetex.hetzner.cloud;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.junit.jupiter.api.BeforeEach;

import net.litetex.hetzner.cloud.image.request.ImageType;
import net.litetex.hetzner.cloud.list.response.ListResponse;
import net.litetex.hetzner.cloud.support.HasID;
import net.litetex.hetzner.cloud.support.api.DeleteAPI;
import net.litetex.hetzner.cloud.support.api.NestedAPI;
import net.litetex.hetzner.cloud.support.api.NestedReadAPI;


public abstract class CloudTest<A extends NestedAPI>
{
	protected static AtomicBoolean initialClean = new AtomicBoolean(false);
	protected HetznerCloudAPI hetznerCloudAPI;
	protected final A api;
	
	public CloudTest(final Function<HetznerCloudAPI, A> apiFunction)
	{
		this.hetznerCloudAPI = new HetznerCloudAPI(Optional.ofNullable(System.getenv("API-KEY"))
			.orElseGet(() -> System.getProperty("API-KEY")));
		this.api = apiFunction.apply(this.hetznerCloudAPI);
	}
	
	@BeforeEach
	protected void beforeEach()
	{
		if(initialClean.compareAndSet(false, true))
		{
			this.ensureClean();
		}
	}
	
	protected void ensureClean()
	{
		deleteAll(this.hetznerCloudAPI.loadBalancers());
		
		deleteAll(this.hetznerCloudAPI.servers(), (api, server) -> api.delete(server.id()));
		
		deleteAll(this.hetznerCloudAPI.certificates());
		deleteAll(this.hetznerCloudAPI.firewalls());
		deleteAll(this.hetznerCloudAPI.floatingIPs());
		this.hetznerCloudAPI.images().listAllData(b -> b
				.type(ImageType.BACKUP)
				.type(ImageType.SNAPSHOT))
			.forEach(i -> this.hetznerCloudAPI.images().delete(i.id()));
		deleteAll(this.hetznerCloudAPI.placementGroups());
		deleteAll(this.hetznerCloudAPI.primaryIPs());
		deleteAll(this.hetznerCloudAPI.sshKeys());
		deleteAll(this.hetznerCloudAPI.volumes());
	}
	
	protected static <A extends NestedReadAPI<? extends ListResponse<T>, T, ?, ?> & DeleteAPI,
		T extends HasID> void deleteAll(final A api)
	{
		deleteAll(api, (a, t) -> a.delete(t.id()));
	}
	
	protected static <A extends NestedReadAPI<? extends ListResponse<T>, T, ?, ?>,
		T extends HasID> void deleteAll(final A api, final BiConsumer<A, T> deleteFunc)
	{
		api.listAllData().forEach(t -> deleteFunc.accept(api, t));
	}
}
