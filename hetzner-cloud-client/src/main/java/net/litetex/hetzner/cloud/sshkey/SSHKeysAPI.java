package net.litetex.hetzner.cloud.sshkey;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.sshkey.request.CreateSSHKeyRequest;
import net.litetex.hetzner.cloud.sshkey.request.ListSSHKeysRequest;
import net.litetex.hetzner.cloud.sshkey.response.SSHKey;
import net.litetex.hetzner.cloud.sshkey.response.SSHKeyResponse;
import net.litetex.hetzner.cloud.sshkey.response.SSHKeysResponse;
import net.litetex.hetzner.cloud.support.NameLabelsRequest;
import net.litetex.hetzner.cloud.support.api.NestedCRUDAPI;


public class SSHKeysAPI
	extends NestedCRUDAPI<SSHKeysResponse, SSHKey, ListSSHKeysRequest,
	SSHKeyResponse,
	SSHKeyResponse, CreateSSHKeyRequest, CreateSSHKeyRequest.Builder,
	NameLabelsRequest, NameLabelsRequest.Builder>
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
			NameLabelsRequest.class,
			NameLabelsRequest.Builder::new);
	}
}
