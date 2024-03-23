package net.litetex.hetzner.cloud;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import net.litetex.hetzner.cloud.certificate.CertificatesAPI;
import net.litetex.hetzner.cloud.datacenter.DatacentersAPI;
import net.litetex.hetzner.cloud.error.response.APIErrorResponse;
import net.litetex.hetzner.cloud.firewall.FirewallsAPI;
import net.litetex.hetzner.cloud.floatingip.FloatingIPsAPI;
import net.litetex.hetzner.cloud.image.ImagesAPI;
import net.litetex.hetzner.cloud.iso.ISOsAPI;
import net.litetex.hetzner.cloud.loadbalancer.LoadBalancersAPI;
import net.litetex.hetzner.cloud.loadbalancertype.LoadBalancerTypesAPI;
import net.litetex.hetzner.cloud.location.LocationsAPI;
import net.litetex.hetzner.cloud.network.NetworksAPI;
import net.litetex.hetzner.cloud.placementgroup.PlacementGroupsAPI;
import net.litetex.hetzner.cloud.pricing.PricingAPI;
import net.litetex.hetzner.cloud.primaryip.PrimaryIPsAPI;
import net.litetex.hetzner.cloud.server.ServersAPI;
import net.litetex.hetzner.cloud.servertype.ServerTypesAPI;
import net.litetex.hetzner.cloud.sshkey.SSHKeysAPI;
import net.litetex.hetzner.cloud.support.api.BaseAPI;
import net.litetex.hetzner.cloud.volume.VolumesAPI;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class HetznerCloudAPI implements BaseAPI
{
	public static final String DEFAULT_BASE_URL = "https://api.hetzner.cloud/v1";
	
	protected final OkHttpClient client;
	protected final String token;
	protected final String baseUrl;
	protected final ObjectMapper objectMapper;
	
	public HetznerCloudAPI(final String token)
	{
		this(token, new OkHttpClient());
	}
	
	public HetznerCloudAPI(final String token, final OkHttpClient client)
	{
		this(token, client, DEFAULT_BASE_URL);
	}
	
	public HetznerCloudAPI(
		final String token,
		final OkHttpClient client,
		final String baseUrl)
	{
		if(token == null || token.isBlank())
		{
			throw new IllegalArgumentException("Invalid api token");
		}
		
		this.token = token;
		
		this.client = Objects.requireNonNull(client);
		
		this.baseUrl = Objects.requireNonNull(baseUrl);
		
		this.objectMapper = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
			.registerModule(new JavaTimeModule())
			.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T exchange(final String path, final String method, final Object body, final Class<T> clazz)
	{
		try(final Response response = this.buildCall(path, method, body).execute())
		{
			final String responseBody = Objects.requireNonNull(response.body(), "No body in response").string();
			
			if(!response.isSuccessful())
			{
				throw new APIRequestException(this.objectMapper.readValue(responseBody, APIErrorResponse.class));
			}
			
			if(String.class.equals(clazz))
			{
				return (T)responseBody;
			}
			
			return this.objectMapper.readValue(responseBody, clazz);
		}
		catch(final IOException e)
		{
			throw new UncheckedIOException(e);
		}
	}
	
	protected Call buildCall(final String path, final String method, final Object body)
		throws JsonProcessingException
	{
		final RequestBody requestBody = body != null
			? RequestBody.create(this.objectMapper.writeValueAsBytes(body), MediaType.get("application/json"))
			: null;
		
		return this.client.newCall(new Request.Builder()
			.addHeader("Authorization", "Bearer " + this.token)
			.addHeader("Accept", "application/json")
			.url(this.baseUrl + path)
			.method(method, requestBody).build());
	}
	
	@Override
	public <T> T get(final String path, final Class<T> clazz)
	{
		return this.exchange(path, "GET", null, clazz);
	}
	
	@Override
	public <T> T delete(final String path, final Class<T> clazz)
	{
		return this.exchange(path, "DELETE", null, clazz);
	}
	
	@Override
	public <T> T put(final String path, final Object body, final Class<T> clazz)
	{
		return this.exchange(path, "PUT", body, clazz);
	}
	
	@Override
	public <T> T post(final String path, final Object body, final Class<T> clazz)
	{
		return this.exchange(path, "POST", body, clazz);
	}
	
	@Override
	public <T> T post(final String path, final Class<T> clazz)
	{
		return this.exchange(
			path,
			"POST",
			this.objectMapper.createObjectNode(),
			clazz);
	}
	
	// region Nested APIs
	
	public CertificatesAPI certificates()
	{
		return new CertificatesAPI(this);
	}
	
	public DatacentersAPI datacenters()
	{
		return new DatacentersAPI(this);
	}
	
	public FirewallsAPI firewalls()
	{
		return new FirewallsAPI(this);
	}
	
	public FloatingIPsAPI floatingIPs()
	{
		return new FloatingIPsAPI(this);
	}
	
	public ImagesAPI images()
	{
		return new ImagesAPI(this);
	}
	
	public ISOsAPI isos()
	{
		return new ISOsAPI(this);
	}
	
	public LoadBalancersAPI loadBalancers()
	{
		return new LoadBalancersAPI(this);
	}
	
	public LoadBalancerTypesAPI loadBalancerTypes()
	{
		return new LoadBalancerTypesAPI(this);
	}
	
	public LocationsAPI locations()
	{
		return new LocationsAPI(this);
	}
	
	public NetworksAPI networks()
	{
		return new NetworksAPI(this);
	}
	
	public PlacementGroupsAPI placementGroups()
	{
		return new PlacementGroupsAPI(this);
	}
	
	public PricingAPI pricing()
	{
		return new PricingAPI(this);
	}
	
	public PrimaryIPsAPI primaryIPs()
	{
		return new PrimaryIPsAPI(this);
	}
	
	public ServersAPI servers()
	{
		return new ServersAPI(this);
	}
	
	public ServerTypesAPI serverTypes()
	{
		return new ServerTypesAPI(this);
	}
	
	public SSHKeysAPI sshKeys()
	{
		return new SSHKeysAPI(this);
	}
	
	public VolumesAPI volumes()
	{
		return new VolumesAPI(this);
	}
	
	// endregion
}
