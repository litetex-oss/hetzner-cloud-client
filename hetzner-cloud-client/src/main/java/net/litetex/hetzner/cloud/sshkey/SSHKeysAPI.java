package net.litetex.hetzner.cloud.sshkey;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.sshkey.request.CreateSSHKeyRequest;
import net.litetex.hetzner.cloud.sshkey.request.ListSSHKeysRequest;
import net.litetex.hetzner.cloud.sshkey.request.UpdateSSHKeyRequest;
import net.litetex.hetzner.cloud.sshkey.response.SSHKey;
import net.litetex.hetzner.cloud.sshkey.response.SSHKeyResponse;
import net.litetex.hetzner.cloud.sshkey.response.SSHKeysResponse;
import net.litetex.hetzner.cloud.support.api.NestedCRUDAPI;


public class SSHKeysAPI
	extends NestedCRUDAPI<SSHKeysResponse, SSHKey, ListSSHKeysRequest,
	SSHKeyResponse,
	SSHKeyResponse, CreateSSHKeyRequest, CreateSSHKeyRequest.Builder,
	UpdateSSHKeyRequest, UpdateSSHKeyRequest.Builder>
{
	public SSHKeysAPI(final HetznerCloudAPI parentAPI)
	{
		super(
			parentAPI,
			"/ssh_keys",
			SSHKeysResponse.class,
			ListSSHKeysRequest::new,
			SSHKeyResponse.class,
			SSHKeyResponse.class,
			CreateSSHKeyRequest.class,
			CreateSSHKeyRequest.Builder::new,
			UpdateSSHKeyRequest.class,
			UpdateSSHKeyRequest.Builder::new);
	}
}
