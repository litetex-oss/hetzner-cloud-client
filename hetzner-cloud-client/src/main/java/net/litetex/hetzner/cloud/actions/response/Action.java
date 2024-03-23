package net.litetex.hetzner.cloud.actions.response;

import java.time.OffsetDateTime;
import java.util.List;

import net.litetex.hetzner.cloud.support.HasID;


public record Action(
    long id,
    String command,
    String status,
    Long progress,
    OffsetDateTime started,
    OffsetDateTime finished,
    List<Resources> resources,
    Error error
) implements HasID
{
    public record Resources(
        Long id,
        String type
    )
    {
    }
    
    
    public record Error(
        String code,
        String message
    )
    {
    }
}
