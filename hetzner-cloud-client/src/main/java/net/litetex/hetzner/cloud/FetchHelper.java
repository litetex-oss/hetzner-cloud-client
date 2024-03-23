package net.litetex.hetzner.cloud;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import net.litetex.hetzner.cloud.list.request.ListRequest;
import net.litetex.hetzner.cloud.list.response.ListResponse;
import net.litetex.hetzner.cloud.shared.Meta;


@SuppressWarnings("java:S119")
public final class FetchHelper
{
	public static <T, RESP extends ListResponse<T>, REQ extends ListRequest<REQ>> List<T> fetchDataUntilEnd(
		final REQ request,
		final Function<REQ, RESP> listFunc)
	{
		return fetchUntilEnd(request, listFunc)
			.stream()
			.map(RESP::data)
			.flatMap(List::stream)
			.toList();
	}
	
	public static <RESP extends ListResponse<?>, REQ extends ListRequest<REQ>> List<RESP> fetchUntilEnd(
		final REQ request,
		final Function<REQ, RESP> listFunc)
	{
		final List<RESP> responses = new ArrayList<>();
		
		Long nextPage = null;
		
		do
		{
			Optional.ofNullable(nextPage).ifPresent(request::page);
			
			final RESP response = listFunc.apply(request);
			responses.add(response);
			nextPage = Optional.ofNullable(response.meta())
				.map(Meta::pagination)
				.map(Meta.Pagination::nextPage)
				.orElse(null);
		}
		while(nextPage != null);
		
		return responses;
	}
	
	private FetchHelper()
	{
	}
}
