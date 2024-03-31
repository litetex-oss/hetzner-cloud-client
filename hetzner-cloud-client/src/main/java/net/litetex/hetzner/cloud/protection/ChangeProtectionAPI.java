package net.litetex.hetzner.cloud.protection;

import java.util.function.Consumer;

import net.litetex.hetzner.cloud.actions.response.ActionResponse;
import net.litetex.hetzner.cloud.protection.request.ChangeProtectionRequest;
import net.litetex.hetzner.cloud.support.BuilderUtil;
import net.litetex.hetzner.cloud.support.api.BaseAPI;


public interface ChangeProtectionAPI extends BaseAPI
{
	default ActionResponse changeProtection(final long id, final ChangeProtectionRequest changeProtection)
	{
		return this.post("/" + id + "/actions/change_protection", changeProtection, ActionResponse.class);
	}
	
	default ActionResponse changeProtection(
		final long id,
		final Consumer<ChangeProtectionRequest.Builder> builderConsumer)
	{
		return this.changeProtection(id, BuilderUtil.build(ChangeProtectionRequest.Builder::new, builderConsumer));
	}
}
