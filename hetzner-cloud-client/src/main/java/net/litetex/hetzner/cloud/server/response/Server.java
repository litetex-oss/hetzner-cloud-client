package net.litetex.hetzner.cloud.server.response;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.datacenter.response.Datacenter;
import net.litetex.hetzner.cloud.image.response.Image;
import net.litetex.hetzner.cloud.iso.response.ISO;
import net.litetex.hetzner.cloud.placementgroup.response.PlacementGroup;
import net.litetex.hetzner.cloud.protection.response.Protection;
import net.litetex.hetzner.cloud.servertype.reponse.ServerType;
import net.litetex.hetzner.cloud.support.HasID;


public record Server(
    long id,
    String name,
    String status,
    OffsetDateTime created,
    @JsonProperty("public_net")
    PublicNet publicNet,
    @JsonProperty("private_net")
    List<PrivateNet> privateNet,
    @JsonProperty("server_type")
    ServerType serverType,
    Datacenter datacenter,
    Image image,
    ISO iso,
    @JsonProperty("rescue_enabled")
    boolean rescueEnabled,
    boolean locked,
    @JsonProperty("backup_window")
    String backupWindow,
    @JsonProperty("outgoing_traffic")
    Long outgoingTraffic,
    @JsonProperty("ingoing_traffic")
    Long ingoingTraffic,
    @JsonProperty("included_traffic")
    Long includedTraffic,
    Protection protection,
    Map<String, String> labels,
    List<Long> volumes,
    @JsonProperty("primary_disk_size")
    Long primaryDiskSize,
    @JsonProperty("load_balancers")
    List<Long> loadBalancers,
    @JsonProperty("placement_group")
    PlacementGroup placementGroup
) implements HasID
{
}
