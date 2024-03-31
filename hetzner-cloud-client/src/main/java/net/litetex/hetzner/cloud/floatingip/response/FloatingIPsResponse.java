package net.litetex.hetzner.cloud.floatingip.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.list.response.ListResponse;
import net.litetex.hetzner.cloud.shared.Meta;


public record FloatingIPsResponse(
    @JsonProperty("floating_ips")
    List<FloatingIP> floatingIps,
    Meta meta
) implements ListResponse<FloatingIP>
{
    @Override
    public List<FloatingIP> data()
    {
        return this.floatingIps();
    }
}
