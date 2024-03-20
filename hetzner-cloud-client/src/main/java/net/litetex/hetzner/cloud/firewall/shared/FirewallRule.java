package net.litetex.hetzner.cloud.firewall.shared;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public record FirewallRule(
    String description,
    @JsonProperty("destination_ips")
    List<String> destinationIPs,
    Direction direction,
    String port,
    Protocol protocol,
    @JsonProperty("source_ips")
    List<String> sourceIPs
)
{
    
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
    
    
    public static class Builder
    {
        private String description;
        private List<String> destinationIPs = new ArrayList<>();
        private Direction direction;
        private String port = "";
        private Protocol protocol;
        private List<String> sourceIPs = new ArrayList<>();
        
        public Builder()
        {
        }
        
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
        
        public Builder direction(final Direction direction)
        {
            this.direction = direction;
            return this;
        }
        
        public Builder port(final String port)
        {
            this.port = port;
            return this;
        }
        
        public Builder protocol(final Protocol protocol)
        {
            this.protocol = protocol;
            return this;
        }
        
        public Builder sourceIPs(final List<String> sourceIPs)
        {
            this.sourceIPs = sourceIPs;
            return this;
        }
        
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
