package net.litetex.hetzner.cloud.placementgroup.request;

import java.util.Map;
import java.util.Objects;

import jakarta.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.placementgroup.shared.PlacementGroupType;
import net.litetex.hetzner.cloud.support.NameLabelsBuilder;


public record CreatePlacementGroupRequest(
    @Nonnull
    String name,
    @JsonProperty("type")
    @Nonnull
    String placementGroupType,
    Map<String, String> labels
)
{
    public CreatePlacementGroupRequest
    {
        Objects.requireNonNull(name);
        Objects.requireNonNull(placementGroupType);
    }
    
    public static class Builder extends NameLabelsBuilder<Builder, CreatePlacementGroupRequest>
    {
        private String placementGroupType = PlacementGroupType.SPREAD;
        
        public Builder placementGroupType(final String placementGroupType)
        {
            this.placementGroupType = placementGroupType;
            return this;
        }
        
        @Override
        public CreatePlacementGroupRequest build()
        {
            return new CreatePlacementGroupRequest(this.name, this.placementGroupType, this.labels);
        }
    }
}
