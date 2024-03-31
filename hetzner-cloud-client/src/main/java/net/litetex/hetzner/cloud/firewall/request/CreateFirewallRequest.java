package net.litetex.hetzner.cloud.firewall.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

import jakarta.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.firewall.shared.FWApplicationTarget;
import net.litetex.hetzner.cloud.firewall.shared.FirewallRule;
import net.litetex.hetzner.cloud.support.BuilderUtil;
import net.litetex.hetzner.cloud.support.NameLabelsBuilder;


public record CreateFirewallRequest(
    @JsonProperty("apply_to")
    List<FWApplicationTarget> applyTo,
    Map<String, String> labels,
    @Nonnull
    String name,
    @JsonProperty("rules")
    List<FirewallRule> firewallRules)
{
    public CreateFirewallRequest
    {
        Objects.requireNonNull(name);
    }
    
    public static class Builder extends NameLabelsBuilder<Builder, CreateFirewallRequest>
    {
        private List<FWApplicationTarget> applyTo;
        private List<FirewallRule> firewallRules;
        
        public Builder applyTo(final List<FWApplicationTarget> applyTo)
        {
            this.applyTo = applyTo;
            return this;
        }
        
        public Builder applyTo(final FWApplicationTarget applyTo)
        {
            if(this.applyTo == null)
            {
                this.applyTo = new ArrayList<>();
            }
            this.applyTo.add(applyTo);
            return this;
        }
        
        public Builder applyTo(final Consumer<FWApplicationTarget.Builder> builderConsumer)
        {
            return this.applyTo(BuilderUtil.build(FWApplicationTarget.Builder::new, builderConsumer));
        }
        
        public Builder firewallRules(final List<FirewallRule> firewallRules)
        {
            this.firewallRules = firewallRules;
            return this;
        }
        
        public Builder firewallRule(final FirewallRule firewallRule)
        {
            if(this.firewallRules == null)
            {
                this.firewallRules = new ArrayList<>();
            }
            this.firewallRules.add(firewallRule);
            return this;
        }
        
        public Builder firewallRule(final Consumer<FirewallRule.Builder> builderConsumer)
        {
            return this.firewallRule(BuilderUtil.build(FirewallRule.Builder::new, builderConsumer));
        }
        
        @Override
        public CreateFirewallRequest build()
        {
            return new CreateFirewallRequest(this.applyTo, this.labels, this.name, this.firewallRules);
        }
    }
}
