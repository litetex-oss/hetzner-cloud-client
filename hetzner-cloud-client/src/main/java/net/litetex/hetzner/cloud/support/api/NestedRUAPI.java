package net.litetex.hetzner.cloud.support.api;

import java.util.function.Consumer;
import java.util.function.Supplier;

import net.litetex.hetzner.cloud.list.request.ListRequest;
import net.litetex.hetzner.cloud.support.IBuilder;


@SuppressWarnings("java:S119")
public abstract class NestedRUAPI<LIST_RES, LIST_REQ extends ListRequest<LIST_REQ>,
	SINGLE_RES,
	UPDATE_REQ, UPDATE_REQ_BUILDER extends IBuilder<UPDATE_REQ>>
	extends NestedReadAPI<LIST_RES, LIST_REQ, SINGLE_RES>
{
	protected final Class<UPDATE_REQ> updateRequestClass;
	protected final Supplier<UPDATE_REQ_BUILDER> updateRequestBuilderSupplier;
	
	protected NestedRUAPI(
		final BaseAPI parentAPI,
		final String pathPrefix,
		final Class<LIST_RES> listResponseClass,
		final Supplier<LIST_REQ> listRequestSupplier,
		final Class<SINGLE_RES> singleResponseClass,
		final Class<UPDATE_REQ> updateRequestClass,
		final Supplier<UPDATE_REQ_BUILDER> updateRequestBuilderSupplier)
	{
		super(parentAPI, pathPrefix, listResponseClass, listRequestSupplier, singleResponseClass);
		this.updateRequestClass = updateRequestClass;
		this.updateRequestBuilderSupplier = updateRequestBuilderSupplier;
	}
	
	public SINGLE_RES update(final long id, final UPDATE_REQ request)
	{
		return this.put("/" + id, request, this.singleResponseClass);
	}
	
	public SINGLE_RES update(final long id, final Consumer<UPDATE_REQ_BUILDER> builderConsumer)
	{
		return this.update(id, this.build(this.updateRequestBuilderSupplier, builderConsumer));
	}
}
