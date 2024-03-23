package net.litetex.hetzner.cloud.servertype.reponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.pricing.response.LocationPrice;
import net.litetex.hetzner.cloud.shared.Deprecation;
import net.litetex.hetzner.cloud.support.HasID;


/**
 * @param deprecated deprecated: <a
 *                   href="https://docs.hetzner.cloud/changelog#2023-06-02-deprecation-info-for-server-types">
 *                   changelog#2023-06-02-deprecation-info-for-server-types</a> <br/> Use {@code deprecation}-field
 *                   instead
 */
public record ServerType(
    long id,
    String name,
    String description,
    Long cores,
    Long memory,
    Long disk,
    @Deprecated
    Boolean deprecated,
    Deprecation deprecation,
    List<LocationPrice> prices,
    @JsonProperty("storage_type")
    String storageType,
    @JsonProperty("cpu_type")
    String cpuType,
    String architecture,
    @JsonProperty("included_traffic")
    Long includedTraffic
) implements HasID
{
}
