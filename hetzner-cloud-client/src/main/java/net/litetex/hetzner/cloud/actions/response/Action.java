package net.litetex.hetzner.cloud.actions.response;

import java.time.OffsetDateTime;
import java.util.List;


public record Action(
    Long id,
    String command,
    String status,
    Long progress,
    OffsetDateTime started,
    OffsetDateTime finished,
    List<Resources> resources,
    Error error
)
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
