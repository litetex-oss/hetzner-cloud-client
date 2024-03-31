package net.litetex.hetzner.cloud.iso.response;

import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record ISOResponse(
	ISO iso
) implements SingleResponse<ISO>
{
	@Override
	public ISO data()
	{
		return this.iso();
	}
}
