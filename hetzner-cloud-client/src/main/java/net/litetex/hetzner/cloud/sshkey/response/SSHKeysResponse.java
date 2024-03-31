package net.litetex.hetzner.cloud.sshkey.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.list.response.ListResponse;
import net.litetex.hetzner.cloud.shared.Meta;


public record SSHKeysResponse(
    @JsonProperty("ssh_keys")
    List<SSHKey> sshKeys,
    Meta meta
) implements ListResponse<SSHKey>
{
    @Override
    public List<SSHKey> data()
    {
        return this.sshKeys();
    }
}
