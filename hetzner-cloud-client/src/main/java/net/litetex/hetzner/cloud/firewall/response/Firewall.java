package net.litetex.hetzner.cloud.firewall.response;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.firewall.shared.FWApplicationTarget;
import net.litetex.hetzner.cloud.firewall.shared.FirewallRule;


public record Firewall(
    @JsonProperty("applied_to")
    List<FWApplicationTarget> appliedTo,
    OffsetDateTime created,
    Long id,
    Map<String, String> labels,
    String name,
    @JsonProperty("rules")
    List<FirewallRule> firewallRules
)
{
}
