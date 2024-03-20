package net.litetex.hetzner.cloud.support;

import java.util.function.Consumer;
import java.util.function.Supplier;


public final class BuilderUtil
{
	public static <B extends IBuilder<T>, T> T build(
		final Supplier<B> builderSupplier,
		final Consumer<B> builderConsumer)
	{
		final B builder = builderSupplier.get();
		builderConsumer.accept(builder);
		return builder.build();
	}
	
	private BuilderUtil()
	{
	}
}
