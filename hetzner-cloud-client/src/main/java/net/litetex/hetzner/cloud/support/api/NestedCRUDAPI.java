package net.litetex.hetzner.cloud.support.api;

import java.util.function.Supplier;

import net.litetex.hetzner.cloud.list.request.ListRequest;
import net.litetex.hetzner.cloud.support.IBuilder;


@SuppressWarnings("java:S119")
public abstract class NestedCRUDAPI<LIST_RES, LIST_REQ extends ListRequest<LIST_REQ>,
	SINGLE_RES,
	CREATE_RES, CREATE_REQ, CREATE_REQ_BUILDER extends IBuilder<CREATE_REQ>,
	UPDATE_REQ, UPDATE_REQ_BUILDER extends IBuilder<UPDATE_REQ>>
	extends NestedCRUAPI<LIST_RES, LIST_REQ,
	SINGLE_RES,
	CREATE_RES, CREATE_REQ, CREATE_REQ_BUILDER,
	UPDATE_REQ, UPDATE_REQ_BUILDER>
	implements DeleteAPI
{
	public NestedCRUDAPI(
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
			createResponseClass,
			createRequestClass,
			createRequestBuilderSupplier,
			updateRequestClass,
			updateRequestBuilderSupplier);
	}
}
