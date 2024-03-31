package net.litetex.hetzner.cloud.support.api;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import net.litetex.hetzner.cloud.FetchHelper;
import net.litetex.hetzner.cloud.RelativeUrlBuilder;
import net.litetex.hetzner.cloud.list.request.ListRequest;
import net.litetex.hetzner.cloud.list.response.ListResponse;
import net.litetex.hetzner.cloud.list.response.SingleResponse;
import net.litetex.hetzner.cloud.support.HasID;


@SuppressWarnings("java:S119")
public abstract class NestedReadAPI<
	LIST_RES extends ListResponse<DATA>, DATA extends HasID, LIST_REQ extends ListRequest<LIST_REQ>,
	SINGLE_RES extends SingleResponse<DATA>>
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
		return this.list((Consumer<LIST_REQ>)null);
	}
	
	public LIST_RES list(final Consumer<LIST_REQ> requestConsumer)
	{
		final LIST_REQ req = this.listRequestSupplier.get();
		if(requestConsumer != null)
		{
			requestConsumer.accept(req);
		}
		return this.list(req);
	}
	
	public LIST_RES list(final LIST_REQ request)
	{
		return this.get(request.applyTo(new RelativeUrlBuilder()).build(), this.listResponseClass);
	}
	
	public List<LIST_RES> listAll()
	{
		return this.listAll((Consumer<LIST_REQ>)null);
	}
	
	public List<LIST_RES> listAll(final Consumer<LIST_REQ> requestConsumer)
	{
		final LIST_REQ req = this.listRequestSupplier.get();
		if(requestConsumer != null)
		{
			requestConsumer.accept(req);
		}
		return this.listAll(req);
	}
	
	public List<LIST_RES> listAll(final LIST_REQ request)
	{
		return FetchHelper.fetchUntilEnd(request, this::list);
	}
	
	public List<DATA> listAllData()
	{
		return this.listAllData((Consumer<LIST_REQ>)null);
	}
	
	public List<DATA> listAllData(final Consumer<LIST_REQ> requestConsumer)
	{
		final LIST_REQ req = this.listRequestSupplier.get();
		if(requestConsumer != null)
		{
			requestConsumer.accept(req);
		}
		return this.listAllData(req);
	}
	
	public List<DATA> listAllData(final LIST_REQ request)
	{
		return FetchHelper.fetchDataUntilEnd(request, this::list);
	}
	
	public SINGLE_RES get(final long id)
	{
		return this.get("/" + id, this.singleResponseClass);
	}
}
