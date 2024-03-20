package net.litetex.hetzner.cloud.server.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import jakarta.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.NameLabelsBuilder;


public record CreateServerRequest(
    @Nonnull
    String name,
    @Nonnull
    @JsonProperty("server_type")
    String serverType,
    String datacenter,
    String location,
    @Nonnull
    String image,
    @JsonProperty("start_after_create")
    boolean startAfterCreate,
    Map<String, String> labels,
    @JsonProperty("ssh_keys")
    List<Object> sshKeys,
    @JsonProperty("user_data")
    String userData,
    List<Long> volumes,
    boolean automount,
    List<Long> networks,
    @JsonProperty("placement_group")
    Long placementGroup,
    @JsonProperty("firewalls")
    List<Firewall> firewalls,
    @JsonProperty("public_net")
    ServerPublicNetRequest publicNet
)
{
    public CreateServerRequest
    {
        Objects.requireNonNull(serverType);
        Objects.requireNonNull(name);
        Objects.requireNonNull(image);
    }
    
    public record Firewall(
        @JsonProperty(value = "firewall")
        long firewallId
    )
    {
    }
    
    
    public static class Builder extends NameLabelsBuilder<Builder, CreateServerRequest>
    {
        private String serverType;
        private String datacenter;
        private String location;
        private String image;
        private boolean startAfterCreate;
        private List<Object> sshKeys;
        private String userData;
        private List<Long> volumes;
        private boolean automount;
        private List<Long> networks;
        private Long placementGroup;
        private List<Firewall> firewalls;
        private ServerPublicNetRequest publicNet;
        
        public Builder serverType(final String serverType)
        {
            this.serverType = serverType != null ? serverType.toLowerCase() : null;
            return this;
        }
        
        public Builder datacenter(final String datacenter)
        {
            this.datacenter = datacenter;
            return this;
        }
        
        public Builder location(final String location)
        {
            this.location = location;
            return this;
        }
        
        public Builder image(final String image)
        {
            this.image = image;
            return this;
        }
        
        public Builder startAfterCreate(final boolean startAfterCreate)
        {
            this.startAfterCreate = startAfterCreate;
            return this;
        }
        
        public Builder sshKeys(final List<Object> sshKeys)
        {
            this.sshKeys = sshKeys;
            return this;
        }
        
        public Builder sshKey(final Integer sshKeyId)
        {
            if(this.sshKeys == null)
            {
                this.sshKeys = new ArrayList<>();
            }
            this.sshKeys.add(sshKeyId);
            return this;
        }
        
        public Builder sshKey(final String sshKeyName)
        {
            if(this.sshKeys == null)
            {
                this.sshKeys = new ArrayList<>();
            }
            this.sshKeys.add(sshKeyName);
            return this;
        }
        
        public Builder userData(final String userData)
        {
            this.userData = userData;
            return this;
        }
        
        public Builder volumes(final List<Long> volumes)
        {
            this.volumes = volumes;
            return this;
        }
        
        public Builder volume(final long volume)
        {
            if(this.volumes == null)
            {
                this.volumes = new ArrayList<>();
            }
            this.volumes.add(volume);
            return this;
        }
        
        public Builder automount(final boolean automount)
        {
            this.automount = automount;
            return this;
        }
        
        public Builder networks(final List<Long> networks)
        {
            this.networks = networks;
            return this;
        }
        
        public Builder network(final long network)
        {
            if(this.networks == null)
            {
                this.networks = new ArrayList<>();
            }
            this.networks.add(network);
            return this;
        }
        
        public Builder placementGroup(final Long placementGroup)
        {
            this.placementGroup = placementGroup;
            return this;
        }
        
        public Builder firewalls(final List<Firewall> firewalls)
        {
            this.firewalls = firewalls;
            return this;
        }
        
        public Builder firewall(final Firewall firewall)
        {
            if(this.firewalls == null)
            {
                this.firewalls = new ArrayList<>();
            }
            this.firewalls.add(firewall);
            return this;
        }
        
        public Builder firewall(final long firewallId)
        {
            return this.firewall(new Firewall(firewallId));
        }
        
        public Builder publicNet(final ServerPublicNetRequest publicNet)
        {
            this.publicNet = publicNet;
            return this;
        }
        
        @Override
        public CreateServerRequest build()
        {
            return new CreateServerRequest(
                this.name,
                this.serverType,
                this.datacenter,
                this.location,
                this.image,
                this.startAfterCreate,
                this.labels,
                this.sshKeys,
                this.userData,
                this.volumes,
                this.automount,
                this.networks,
                this.placementGroup,
                this.firewalls,
                this.publicNet);
        }
    }
}
