package net.litetex.hetzner.cloud;

import java.util.function.Function;

import org.junit.jupiter.api.Test;

import net.litetex.hetzner.cloud.support.HasID;
import net.litetex.hetzner.cloud.support.api.NestedReadAPI;


public abstract class CRUDTest<A extends NestedReadAPI<?, T, ?, ?>, T extends HasID> extends ReadOnlyAPITest<A, T>
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
	
	protected abstract void delete(T created);
}
