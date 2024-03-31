package net.litetex.hetzner.cloud.shared;

import com.fasterxml.jackson.annotation.JsonProperty;


public record Meta(Pagination pagination)
{
	public record Pagination(
		long page,
		@JsonProperty("per_page")
		long perPage,
		@JsonProperty("previous_page")
		Long previousPage,
		@JsonProperty("next_page")
		Long nextPage,
		@JsonProperty("last_page")
		Long lastPage,
		@JsonProperty("total_entries")
		Long totalEntries)
	{
	}
}
