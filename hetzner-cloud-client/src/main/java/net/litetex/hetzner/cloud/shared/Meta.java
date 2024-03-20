package net.litetex.hetzner.cloud.shared;

import com.fasterxml.jackson.annotation.JsonProperty;


public record Meta(Pagination pagination)
{
	public record Pagination(
		Long page,
		@JsonProperty("per_page")
		Long perPage,
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
