package net.litetex.hetzner.cloud.sshkey.response;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import net.litetex.hetzner.cloud.support.HasID;


public record SSHKey(
	long id,
	String name,
	String fingerprint,
	@JsonProperty("public_key")
	String publicKey,
	Map<String, String> labels
) implements HasID
{
}
