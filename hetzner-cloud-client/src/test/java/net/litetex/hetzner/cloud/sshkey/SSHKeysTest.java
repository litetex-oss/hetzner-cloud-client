package net.litetex.hetzner.cloud.sshkey;

import org.junit.jupiter.api.Assertions;

import net.litetex.hetzner.cloud.CRUDTest;
import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.sshkey.response.SSHKey;


@SuppressWarnings("java:S2187") // Test are in parent
class SSHKeysTest extends CRUDTest<SSHKeysAPI, SSHKey>
{
	public SSHKeysTest()
	{
		super(HetznerCloudAPI::sshKeys);
	}
	
	@Override
	protected SSHKey create()
	{
		return this.api.create(b -> b.name("test")
				.publicKey("ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIIMIhrOVWFT8uH0iz9w+FASuIUxbprwpAnnrJCgtxUuK"))
			.sshKey();
	}
	
	@Override
	protected void update(final SSHKey created)
	{
		this.api.update(created.id(), b -> b.label("x", "y"));
	}
	
	@Override
	protected SSHKey get(final Long id)
	{
		final SSHKey sshKey = super.get(id);
		Assertions.assertEquals("58:3b:bb:86:a4:bc:f3:74:8c:17:72:bc:86:00:8d:3e", sshKey.fingerprint());
		Assertions.assertEquals("y", sshKey.labels().get("x"));
		return sshKey;
	}
}
