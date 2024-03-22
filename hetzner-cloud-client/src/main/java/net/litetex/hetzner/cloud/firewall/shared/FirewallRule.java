package net.litetex.hetzner.cloud.firewall.shared;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.IBuilder;


public record FirewallRule(
    String description,
    @JsonProperty("destination_ips")
    List<String> destinationIPs,
    @Nonnull
    String direction,
    String port,
    @Nonnull
    String protocol,
    @JsonProperty("source_ips")
    List<String> sourceIPs
)
{
    public FirewallRule
    {
        Objects.requireNonNull(direction);
        Objects.requireNonNull(protocol);
    }
    
    public static final class Direction
    {
        public static final String IN = "in";
        public static final String OUT = "out";
        
        private Direction()
        {
        }
    }
    
    
    public static final class Protocol
    {
        public static final String TCP = "tcp";
        public static final String UDP = "udp";
        public static final String ICMP = "icmp";
        public static final String ESP = "esp";
        public static final String GRE = "gre";
        
        private Protocol()
        {
        }
    }
    
    
    public static class Builder implements IBuilder<FirewallRule>
    {
        private String description;
        private List<String> destinationIPs;
        private String direction;
        private String port;
        private String protocol;
        private List<String> sourceIPs;
        
        public Builder description(final String description)
        {
            this.description = description;
            return this;
        }
        
        public Builder destinationIPs(final List<String> destinationIPs)
        {
            this.destinationIPs = destinationIPs;
            return this;
        }
        
        public Builder destinationIP(final String destinationIP)
        {
            if(this.destinationIPs == null)
            {
                this.destinationIPs = new ArrayList<>();
            }
            this.destinationIPs.add(destinationIP);
            return this;
        }
        
        public Builder direction(final String direction)
        {
            this.direction = direction;
            return this;
        }
        
        public Builder port(final String port)
        {
            this.port = port;
            return this;
        }
        
        public Builder protocol(final String protocol)
        {
            this.protocol = protocol;
            return this;
        }
        
        public Builder sourceIPs(final List<String> sourceIPs)
        {
            this.sourceIPs = sourceIPs;
            return this;
        }
        
        public Builder sourceIP(final String sourceIP)
        {
            if(this.sourceIPs == null)
            {
				this.sourceIPs = new ArrayList<>();
            }
            this.sourceIPs.add(sourceIP);
            return this;
        }
        
        @Override
        public FirewallRule build()
        {
            return new FirewallRule(
                this.description,
                this.destinationIPs,
                this.direction,
                this.port,
                this.protocol,
                this.sourceIPs);
        }
    }
}
