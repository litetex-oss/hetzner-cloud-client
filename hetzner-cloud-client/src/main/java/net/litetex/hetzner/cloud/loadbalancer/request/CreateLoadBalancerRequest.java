package net.litetex.hetzner.cloud.loadbalancer.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.loadbalancer.shared.LBAlgorithm;
import net.litetex.hetzner.cloud.loadbalancer.shared.service.LBService;
import net.litetex.hetzner.cloud.loadbalancer.shared.target.LBTarget;
import net.litetex.hetzner.cloud.support.BuilderUtil;
import net.litetex.hetzner.cloud.support.NameLabelsBuilder;


public record CreateLoadBalancerRequest(
    LBAlgorithm algorithm,
    Map<String, String> labels,
    @JsonProperty("load_balancer_type")
    String loadBalancerType,
    String location,
    String name,
    Long network,
    @JsonProperty("network_zone")
    String networkZone,
    @JsonProperty("public_interface")
    Boolean publicInterface,
    List<LBService> services,
    List<LBTarget> targets
)
{
    public CreateLoadBalancerRequest
    {
        Objects.requireNonNull(loadBalancerType);
        Objects.requireNonNull(name);
    }
    
    public static class Builder extends NameLabelsBuilder<Builder, CreateLoadBalancerRequest>
    {
        private LBAlgorithm algorithm;
        private String loadBalancerType;
        private String location;
        private Long network;
        private String networkZone;
        private Boolean publicInterface;
        private List<LBService> services;
        private List<LBTarget> targets;
        
        public Builder algorithm(final LBAlgorithm algorithm)
        {
            this.algorithm = algorithm;
            return this;
        }
        
        public Builder algorithm(final String algorithmType)
        {
            return this.algorithm(new LBAlgorithm(algorithmType));
        }
        
        
        public Builder loadBalancerType(final String loadBalancerType)
        {
            this.loadBalancerType = loadBalancerType;
            return this;
        }
        
        public Builder location(final String location)
        {
            this.location = location;
            return this;
        }
        
        public Builder network(final Long network)
        {
            this.network = network;
            return this;
        }
        
        public Builder networkZone(final String networkZone)
        {
            this.networkZone = networkZone;
            return this;
        }
        
        public Builder publicInterface(final Boolean publicInterface)
        {
            this.publicInterface = publicInterface;
            return this;
        }
        
        public Builder services(final List<LBService> services)
        {
            this.services = services;
            return this;
        }
        
        public Builder service(final LBService service)
        {
            if(this.services == null)
            {
                this.services = new ArrayList<>();
            }
            this.services.add(service);
            return this;
        }
        
        public Builder service(final Consumer<LBService.Builder> builderConsumer)
        {
            return this.service(BuilderUtil.build(LBService.Builder::new, builderConsumer));
        }
        
        public Builder targets(final List<LBTarget> targets)
        {
            this.targets = targets;
            return this;
        }
        
        public Builder target(final LBTarget target)
        {
            if(this.targets == null)
            {
                this.targets = new ArrayList<>();
            }
            this.targets.add(target);
            return this;
        }
        
        public Builder target(final Consumer<LBTarget.Builder> builderConsumer)
        {
            return this.target(BuilderUtil.build(LBTarget.Builder::new, builderConsumer));
        }
        
        @Override
        public CreateLoadBalancerRequest build()
        {
            return new CreateLoadBalancerRequest(
                this.algorithm,
                this.labels,
                this.loadBalancerType,
                this.location,
                this.name,
                this.network,
                this.networkZone,
                this.publicInterface,
                this.services,
                this.targets);
        }
    }
}
