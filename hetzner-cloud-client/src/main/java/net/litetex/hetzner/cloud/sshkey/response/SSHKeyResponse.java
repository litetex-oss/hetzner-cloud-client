package net.litetex.hetzner.cloud.sshkey.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.list.response.SingleResponse;


public record SSHKeyResponse(
    @JsonProperty("ssh_key")
    SSHKey sshKey
) implements SingleResponse<SSHKey>
{
    @Override
    public SSHKey data()
    {
        return this.sshKey();
    }
}
