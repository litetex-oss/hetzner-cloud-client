package net.litetex.hetzner.cloud.protection.response;

// TODO: Protection not always contains REBUILD! Just for servers
public record Protection(
	Boolean delete,
	Boolean rebuild
)
{
}
