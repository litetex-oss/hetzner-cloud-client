package net.litetex.hetzner.cloud.list.response;

import java.util.List;

import net.litetex.hetzner.cloud.shared.Meta;


public interface ListResponse<T>
{
	List<T> data();
	
	default Meta meta()
	{
		return null;
	}
}
