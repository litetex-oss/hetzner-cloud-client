package net.litetex.hetzner.cloud.firewall.response;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.firewall.shared.FWApplicationTarget;
import net.litetex.hetzner.cloud.firewall.shared.FirewallRule;
import net.litetex.hetzner.cloud.support.HasID;


public record Firewall(
    long id,
    String name,
    @JsonProperty("applied_to")
    List<FWApplicationTarget> appliedTo,
    OffsetDateTime created,
    Map<String, String> labels,
    @JsonProperty("rules")
    List<FirewallRule> firewallRules
) implements HasID
{
}
