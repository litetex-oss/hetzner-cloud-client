package net.litetex.hetzner.cloud.primaryip.response;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.datacenter.response.Datacenter;
import net.litetex.hetzner.cloud.shared.DnsPTR;


public record PrimaryIP(
    long id,
    String ip,
    String name,
    @JsonProperty("assignee_id")
    Long assigneeId,
    @JsonProperty("assignee_type")
    String ipAssigneeType,
    @JsonProperty("type")
    String ipType,
    @JsonProperty("auto_delete")
    Boolean autoDelete,
    Boolean blocked,
    OffsetDateTime created,
    Datacenter datacenter,
    @JsonProperty("dns_ptr")
    List<DnsPTR> dnsPtr,
    Map<String, String> labels
)
{
}
