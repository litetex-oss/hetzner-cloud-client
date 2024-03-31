package net.litetex.hetzner.cloud.servertype;

import net.litetex.hetzner.cloud.HetznerCloudAPI;
import net.litetex.hetzner.cloud.list.request.DefaultListRequest;
import net.litetex.hetzner.cloud.servertype.reponse.ServerType;
import net.litetex.hetzner.cloud.servertype.reponse.ServerTypeResponse;
import net.litetex.hetzner.cloud.servertype.reponse.ServerTypesResponse;
import net.litetex.hetzner.cloud.support.api.NestedReadAPI;


public class ServerTypesAPI
	extends NestedReadAPI<ServerTypesResponse, ServerType, DefaultListRequest, ServerTypeResponse>
{
	public ServerTypesAPI(final HetznerCloudAPI parentAPI)
	{
		super(
			parentAPI,
			"/server_types",
			ServerTypesResponse.class,
			DefaultListRequest::new,
			ServerTypeResponse.class);
	}
}
