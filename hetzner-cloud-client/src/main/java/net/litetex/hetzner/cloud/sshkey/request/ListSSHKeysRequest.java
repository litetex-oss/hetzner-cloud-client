package net.litetex.hetzner.cloud.sshkey.request;

import net.litetex.hetzner.cloud.RelativeUrlBuilder;
import net.litetex.hetzner.cloud.list.request.ListRequest;


public class ListSSHKeysRequest extends ListRequest<ListSSHKeysRequest>
{
	protected String fingerprint;
	
	public ListSSHKeysRequest fingerprint(final String fingerprint)
	{
		this.fingerprint = fingerprint;
		return this.self();
	}
	
	@Override
	public RelativeUrlBuilder applyTo(final RelativeUrlBuilder relativeUrlBuilder)
	{
		return super.applyTo(relativeUrlBuilder)
			.queryParam("fingerprint", this.fingerprint);
	}
}
