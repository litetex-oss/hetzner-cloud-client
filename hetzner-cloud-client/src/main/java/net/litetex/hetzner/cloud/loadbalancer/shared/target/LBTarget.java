package net.litetex.hetzner.cloud.loadbalancer.shared.target;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

import jakarta.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.BuilderUtil;
import net.litetex.hetzner.cloud.support.IBuilder;


public record LBTarget(
    @JsonProperty("health_status")
    List<HealthStatus> healthStatuses,
    @JsonProperty("ip")
    LBTargetIP ip,
    @JsonProperty("label_selector")
    LBTargetLabelSelector labelSelector,
    @JsonProperty("server")
    LBTargetServer server,
    List<Target> targets,
    @Nonnull
    @JsonProperty("type")
    String targetType,
    @JsonProperty("use_private_ip")
    Boolean usePrivateIp
)
{
    public LBTarget
    {
        Objects.requireNonNull(targetType);
    }
    
    public record HealthStatus(
        @JsonProperty("listen_port")
        Integer listenPort,
        String status
    )
    {
        public static final class HealthStatusStatus
        {
            public static final String HEALTHY = "healthy";
            public static final String UNHEALTHY = "unhealthy";
            public static final String UNKNOWN = "unknown";
            
            private HealthStatusStatus()
            {
            }
        }
        
        
        public static class Builder implements IBuilder<HealthStatus>
        {
            private Integer listenPort;
            private String status;
            
            public Builder listenPort(final Integer listenPort)
            {
                this.listenPort = listenPort;
                return this;
            }
            
            public Builder status(final String status)
            {
                this.status = status;
                return this;
            }
            
            @Override
            public HealthStatus build()
            {
                return new HealthStatus(this.listenPort, this.status);
            }
        }
    }
    
    public record Target(
        @JsonProperty("health_status")
        List<HealthStatus> healthStatus,
        LBTargetServer server,
        String type,
        @JsonProperty("use_private_ip")
        Boolean usePrivateIp
    )
    {
        public static class Builder implements IBuilder<Target>
        {
            private List<HealthStatus> healthStatus;
            private LBTargetServer server;
            // 2024-03 Docs: Here always "server"
            private String type = LBTargetType.SERVER;
            private Boolean usePrivateIp;
            
            public Builder healthStatus(final List<HealthStatus> healthStatus)
            {
                this.healthStatus = healthStatus;
                return this;
            }
            
            public Builder healthStatus(final HealthStatus healthStatus)
            {
                if(this.healthStatus == null)
                {
                    this.healthStatus = new ArrayList<>();
                }
                this.healthStatus.add(healthStatus);
                return this;
            }
            
            public Builder healthStatus(final Consumer<HealthStatus.Builder> builderConsumer)
            {
                return this.healthStatus(BuilderUtil.build(HealthStatus.Builder::new, builderConsumer));
            }
            
            public Builder server(final LBTargetServer server)
            {
                this.server = server;
                return this;
            }
            
            public Builder type(final String type)
            {
                this.type = type;
                return this;
            }
            
            public Builder usePrivateIp(final Boolean usePrivateIp)
            {
                this.usePrivateIp = usePrivateIp;
                return this;
            }
            
            @Override
            public Target build()
            {
                return new Target(
					this.healthStatus,
					this.server,
					this.type,
					this.usePrivateIp);
            }
        }
    }
    
    
    public static class Builder implements IBuilder<LBTarget>
    {
        private List<HealthStatus> healthStatuses;
        private LBTargetIP ip;
        private LBTargetLabelSelector labelSelector;
        private LBTargetServer server;
        private List<Target> targets;
        private String targetType;
        private Boolean usePrivateIp;
        
        public Builder healthStatuses(final List<HealthStatus> healthStatus)
        {
            this.healthStatuses = healthStatus;
            return this;
        }
        
        public Builder healthStatus(final HealthStatus healthStatus)
        {
            if(this.healthStatuses == null)
            {
                this.healthStatuses = new ArrayList<>();
            }
            this.healthStatuses.add(healthStatus);
            return this;
        }
        
        public Builder healthStatus(final Consumer<HealthStatus.Builder> builderConsumer)
        {
            return this.healthStatus(BuilderUtil.build(HealthStatus.Builder::new, builderConsumer));
        }
        
        public Builder ip(final LBTargetIP ip)
        {
            this.ip = ip;
            return this;
        }
        
        public Builder ip(final String ip)
        {
            return this.ip(new LBTargetIP(ip));
        }
        
        public Builder labelSelector(final LBTargetLabelSelector labelSelector)
        {
            this.labelSelector = labelSelector;
            return this;
        }
        
        public Builder labelSelector(final String labelSelector)
        {
            return this.labelSelector(new LBTargetLabelSelector(labelSelector));
        }
        
        public Builder server(final LBTargetServer server)
        {
            this.server = server;
            return this;
        }
        
        public Builder server(final long serverId)
        {
            return this.server(new LBTargetServer(serverId));
        }
        
        public Builder targets(final List<Target> targets)
        {
            this.targets = targets;
            return this;
        }
        
        public Builder target(final Target target)
        {
            if(this.targets == null)
            {
				this.targets = new ArrayList<>();
            }
			this.targets.add(target);
            return this;
        }
        
        public Builder target(final Consumer<Target.Builder> builderConsumer)
        {
            return this.target(BuilderUtil.build(Target.Builder::new, builderConsumer));
        }
        
        public Builder targetType(final String targetType)
        {
            this.targetType = targetType;
            return this;
        }
        
        public Builder usePrivateIp(final Boolean usePrivateIp)
        {
            this.usePrivateIp = usePrivateIp;
            return this;
        }
        
        @Override
        public LBTarget build()
        {
            return new LBTarget(
                this.healthStatuses,
                this.ip,
				this.labelSelector,
                this.server,
                this.targets,
				Optional.ofNullable(this.targetType)
					.orElseGet(() -> {
						if(this.server != null)
						{
							return LBTargetType.SERVER;
						}
						if(this.ip != null)
						{
							return LBTargetType.IP;
						}
						if(this.labelSelector != null)
						{
							return LBTargetType.LABEL_SELECTOR;
						}
						throw new IllegalStateException("Unable to determine targetType automatically");
					}),
                this.usePrivateIp);
        }
    }
}
