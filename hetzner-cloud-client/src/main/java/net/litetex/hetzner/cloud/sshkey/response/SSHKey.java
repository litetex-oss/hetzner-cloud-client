package net.litetex.hetzner.cloud.sshkey.response;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;


public record SSHKey(
	Long id,
	String name,
	String fingerprint,
	@JsonProperty("public_key")
	String publicKey,
	Map<String, String> labels
)
{
}
