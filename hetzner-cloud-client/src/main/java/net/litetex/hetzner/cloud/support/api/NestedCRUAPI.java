package net.litetex.hetzner.cloud.support.api;

import java.util.function.Consumer;
import java.util.function.Supplier;

import net.litetex.hetzner.cloud.list.request.ListRequest;
import net.litetex.hetzner.cloud.list.response.ListResponse;
import net.litetex.hetzner.cloud.list.response.SingleResponse;
import net.litetex.hetzner.cloud.support.HasID;
import net.litetex.hetzner.cloud.support.IBuilder;


@SuppressWarnings("java:S119")
public abstract class NestedCRUAPI<
	LIST_RES extends ListResponse<DATA>, DATA extends HasID, LIST_REQ extends ListRequest<LIST_REQ>,
	SINGLE_RES extends SingleResponse<DATA>,
	CREATE_RES extends SingleResponse<DATA>, CREATE_REQ, CREATE_REQ_BUILDER extends IBuilder<CREATE_REQ>,
	UPDATE_REQ, UPDATE_REQ_BUILDER extends IBuilder<UPDATE_REQ>>
	extends NestedRUAPI<LIST_RES, DATA, LIST_REQ,
	SINGLE_RES,
	UPDATE_REQ, UPDATE_REQ_BUILDER>
{
	protected final Class<CREATE_RES> createResponseClass;
	protected final Class<CREATE_REQ> createRequestClass;
	protected final Supplier<CREATE_REQ_BUILDER> createRequestBuilderSupplier;
	
	protected NestedCRUAPI(
		final BaseAPI parentAPI,
		final String pathPrefix,
		final Class<LIST_RES> listResponseClass,
		final Supplier<LIST_REQ> listRequestSupplier,
		final Class<SINGLE_RES> singleResponseClass,
		final Class<CREATE_RES> createResponseClass,
		final Class<CREATE_REQ> createRequestClass,
		final Supplier<CREATE_REQ_BUILDER> createRequestBuilderSupplier,
		final Class<UPDATE_REQ> updateRequestClass,
		final Supplier<UPDATE_REQ_BUILDER> updateRequestBuilderSupplier)
	{
		super(
			parentAPI,
			pathPrefix,
			listResponseClass,
			listRequestSupplier,
			singleResponseClass,
			updateRequestClass,
			updateRequestBuilderSupplier);
		this.createResponseClass = createResponseClass;
		this.createRequestClass = createRequestClass;
		this.createRequestBuilderSupplier = createRequestBuilderSupplier;
	}
	
	public CREATE_RES create(final CREATE_REQ request)
	{
		return this.post("", request, this.createResponseClass);
	}
	
	public CREATE_RES create(final Consumer<CREATE_REQ_BUILDER> builderConsumer)
	{
		return this.create(this.build(this.createRequestBuilderSupplier, builderConsumer));
	}
}
