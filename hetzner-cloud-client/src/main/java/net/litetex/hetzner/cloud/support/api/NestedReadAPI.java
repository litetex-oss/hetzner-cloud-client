package net.litetex.hetzner.cloud.support.api;

import java.util.function.Consumer;
import java.util.function.Supplier;

import net.litetex.hetzner.cloud.RelativeUrlBuilder;
import net.litetex.hetzner.cloud.list.request.ListRequest;


@SuppressWarnings("java:S119")
public abstract class NestedReadAPI<
	LIST_RES, LIST_REQ extends ListRequest<LIST_REQ>,
	SINGLE_RES>
	extends NestedAPI
{
	protected final Class<LIST_RES> listResponseClass;
	protected final Supplier<LIST_REQ> listRequestSupplier;
	protected final Class<SINGLE_RES> singleResponseClass;
	
	protected NestedReadAPI(
		final BaseAPI parentAPI,
		final String pathPrefix,
		final Class<LIST_RES> listResponseClass,
		final Supplier<LIST_REQ> listRequestSupplier,
		final Class<SINGLE_RES> singleResponseClass)
	{
		super(parentAPI, pathPrefix);
		this.listResponseClass = listResponseClass;
		this.listRequestSupplier = listRequestSupplier;
		this.singleResponseClass = singleResponseClass;
	}
	
	public LIST_RES list()
	{
		return this.get("", this.listResponseClass);
	}
	
	public LIST_RES list(final LIST_REQ request)
	{
		return this.get(request.applyTo(new RelativeUrlBuilder()).build(), this.listResponseClass);
	}
	
	public LIST_RES list(final Consumer<LIST_REQ> requestConsumer)
	{
		final LIST_REQ req = this.listRequestSupplier.get();
		requestConsumer.accept(req);
		return this.list(req);
	}
	
	public SINGLE_RES get(final long id)
	{
		return this.get("/" + id, this.singleResponseClass);
	}
}
