package net.litetex.hetzner.cloud.rdns;

import java.util.function.Consumer;

import net.litetex.hetzner.cloud.actions.response.ActionResponse;
import net.litetex.hetzner.cloud.rdns.request.ChangeReverseDNSRequest;
import net.litetex.hetzner.cloud.support.BuilderUtil;
import net.litetex.hetzner.cloud.support.api.BaseAPI;


public interface ChangeDNSPTRAPI extends BaseAPI
{
	default ActionResponse changeDNSPTR(final long id, final ChangeReverseDNSRequest request)
	{
		return this.post("/" + id + "/actions/change_dns_ptr", request, ActionResponse.class);
	}
	
	default ActionResponse changeDNSPTR(
		final long id,
		final Consumer<ChangeReverseDNSRequest.Builder> builderConsumer)
	{
		return this.changeDNSPTR(id, BuilderUtil.build(ChangeReverseDNSRequest.Builder::new, builderConsumer));
	}
}
