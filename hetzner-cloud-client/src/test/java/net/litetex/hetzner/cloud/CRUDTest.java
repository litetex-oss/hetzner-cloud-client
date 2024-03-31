package net.litetex.hetzner.cloud;

import java.util.function.Function;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.litetex.hetzner.cloud.list.response.ListResponse;
import net.litetex.hetzner.cloud.support.HasID;
import net.litetex.hetzner.cloud.support.api.DeleteAPI;
import net.litetex.hetzner.cloud.support.api.NestedReadAPI;


public abstract class CRUDTest<A extends NestedReadAPI<? extends ListResponse<T>, T, ?, ?>, T extends HasID>
	extends ReadOnlyAPITest<A, T>
{
	protected CRUDTest(final Function<HetznerCloudAPI, A> apiFunction)
	{
		super(apiFunction);
	}
	
	@Test
	@Override
	protected void check()
	{
		final T created = this.create();
		
		this.update(created);
		
		this.list();
		
		this.get(created.id());
		
		this.additionalChecks(created);
		
		this.delete(created);
	}
	
	protected abstract T create();
	
	protected abstract void update(T created);
	
	protected void additionalChecks(final T created)
	{
		// Do nothing by default
	}
	
	protected void delete(final T created)
	{
		final long id = created.id();
		if(this.api instanceof final DeleteAPI deleteAPI)
		{
			deleteAPI.delete(id);
		}
		
		Assertions.assertThrows(APIRequestException.class, () -> this.api.get(id));
	}
	
	@AfterEach
	protected void afterEach()
	{
		if(!(this.api instanceof final DeleteAPI deleteAPI))
		{
			throw new UnsupportedOperationException("Can't clean up as api is not a DeleteAPI; Please override");
		}
		this.api.listAllData().forEach(c -> deleteAPI.delete(c.id()));
	}
}
