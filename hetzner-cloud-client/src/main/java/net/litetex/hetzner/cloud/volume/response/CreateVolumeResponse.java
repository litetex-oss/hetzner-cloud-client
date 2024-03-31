package net.litetex.hetzner.cloud.volume.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.actions.response.Action;
import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record CreateVolumeResponse(
    Action action,
    @JsonProperty("next_actions")
    List<Action> nextActions,
    Volume volume
) implements SingleResponse<Volume>
{
    @Override
    public Volume data()
    {
        return this.volume();
    }
}
