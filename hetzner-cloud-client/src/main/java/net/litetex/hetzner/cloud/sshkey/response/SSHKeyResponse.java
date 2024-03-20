package net.litetex.hetzner.cloud.sshkey.response;

import com.fasterxml.jackson.annotation.JsonProperty;


public record SSHKeyResponse(
    @JsonProperty("ssh_key")
    SSHKey sshKey
)
{
}
