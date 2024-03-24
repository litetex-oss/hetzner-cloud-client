package net.litetex.hetzner.cloud;

import java.util.List;
import java.util.function.Function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import net.litetex.hetzner.cloud.support.HasID;
import net.litetex.hetzner.cloud.support.api.NestedReadAPI;


public abstract class ReadOnlyAPITest<A extends NestedReadAPI<?, T, ?, ?>, T extends HasID> extends CloudTest<A>
{
	protected ReadOnlyAPITest(final Function<HetznerCloudAPI, A> apiFunction)
	{
		super(apiFunction);
	}
	
	@Test
	protected void check()
	{
		final List<T> results = this.list();
		
		this.get(results.stream().findFirst().map(HasID::id).orElse(null));
	}
	
	protected List<T> list()
	{
		final List<T> results = this.api.listAllData();
		Assertions.assertFalse(results.isEmpty());
		
		return results;
	}
	
	protected T get(final Long id)
	{
		final T data = Assertions.assertDoesNotThrow(() -> this.api.get(id)).data();
		Assertions.assertTrue(data.id() > 0);
		return data;
	}
}
