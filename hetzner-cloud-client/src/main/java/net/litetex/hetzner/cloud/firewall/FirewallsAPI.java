package net.litetex.hetzner.cloud.firewall;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.actions.ActionsAPI;
import net.litetex.hetzner.cloud.actions.response.ActionsResponse;
import net.litetex.hetzner.cloud.firewall.request.CreateFirewallRequest;
import net.litetex.hetzner.cloud.firewall.response.CreateFirewallResponse;
import net.litetex.hetzner.cloud.firewall.response.FirewallResponse;
import net.litetex.hetzner.cloud.firewall.response.FirewallsResponse;
import net.litetex.hetzner.cloud.firewall.shared.FWApplicationTarget;
import net.litetex.hetzner.cloud.firewall.shared.FirewallRule;
import net.litetex.hetzner.cloud.list.request.DefaultListRequest;
import net.litetex.hetzner.cloud.support.NameLabelsRequest;
import net.litetex.hetzner.cloud.support.api.NestedCRUDAPI;


public class FirewallsAPI
	extends NestedCRUDAPI<FirewallsResponse, DefaultListRequest,
	FirewallResponse,
	CreateFirewallResponse, CreateFirewallRequest, CreateFirewallRequest.Builder,
	NameLabelsRequest, NameLabelsRequest.Builder>
	implements ActionsAPI
{
	public FirewallsAPI(final HetznerCloudAPI parentAPI)
	{
		super(
			parentAPI,
			"/firewalls",
			FirewallsResponse.class,
			DefaultListRequest::new,
			FirewallResponse.class,
			CreateFirewallResponse.class,
			CreateFirewallRequest.class,
			CreateFirewallRequest.Builder::new,
			NameLabelsRequest.class,
			NameLabelsRequest.Builder::new);
	}
	
	public ActionsResponse applyToResources(final long id, final List<FWApplicationTarget> applicationTargets)
	{
		return this.post(
			"/" + id + "/actions/apply_to_resources",
			Map.of("apply_to", applicationTargets),
			ActionsResponse.class);
	}
	
	public ActionsResponse removeFromResources(final long id, final List<FWApplicationTarget> removalTargets)
	{
		return this.post(
			"/" + id + "/actions/remove_from_resources",
			Map.of("remove_from", removalTargets),
			ActionsResponse.class);
	}
	
	public ActionsResponse removeAllRulesFromFirewall(final long id)
	{
		return this.setFirewallRules(id, Collections.emptyList());
	}
	
	public ActionsResponse setFirewallRules(final long id, final List<FirewallRule> firewallRules)
	{
		return this.post(
			"/" + id + "/actions/set_rules",
			Map.of("rules", firewallRules),
			ActionsResponse.class);
	}
}
