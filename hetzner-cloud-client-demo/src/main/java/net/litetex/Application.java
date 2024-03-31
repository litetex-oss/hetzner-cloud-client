package net.litetex;

import java.util.Optional;
import java.util.Scanner;

import net.litetex.hetzner.cloud.HetznerCloudAPI;


@SuppressWarnings("java:S106")
public final class Application
{
	public static void main(final String[] args)
	{
		String apiKey = Optional.ofNullable(System.getenv("API-KEY"))
			.orElseGet(() -> System.getProperty("API-KEY"));
		if(apiKey == null)
		{
			System.out.println("Required API-KEY not set in environment variables or system properties");
			
			System.out.println("Please provide API Key over console:");
			try(final Scanner scanner = new Scanner(System.in))
			{
				apiKey = scanner.nextLine();
			}
			
			if(apiKey == null || apiKey.isBlank())
			{
				System.out.println("Invalid key; Aborting");
				System.exit(1);
			}
		}
		
		final HetznerCloudAPI hetznerCloudAPI = new HetznerCloudAPI(apiKey);
		System.out.println(hetznerCloudAPI.servers().list());
		System.out.println(hetznerCloudAPI.firewalls().list());
		System.out.println(hetznerCloudAPI.pricing().get());
	}
	
	private Application()
	{
	}
}
