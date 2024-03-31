[![Latest version](https://img.shields.io/maven-central/v/net.litetex/hetzner-cloud-client?logo=apache%20maven)](https://mvnrepository.com/artifact/net.litetex/hetzner-cloud-client)
[![Build](https://img.shields.io/github/actions/workflow/status/litetex-oss/hetzner-cloud-client/checkBuild.yml?branch=dev)](https://github.com/litetex-oss/hetzner-cloud-client/actions/workflows/checkBuild.yml?query=branch%3Adev)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=litetex-oss_hetzner-cloud-client&metric=alert_status)](https://sonarcloud.io/dashboard?id=litetex-oss_hetzner-cloud-client)

# hetzner-cloud-client

A Java client for the [Hetzner Cloud API](https://docs.hetzner.cloud/)

## Usage

Example: Create a firewall and a server
```java
HetznerCloudAPI api = new HetznerCloudAPI("API-TOKEN");

Firewall firewall = api.firewalls().create(b -> b
        .name("allow-icmp-from-everywhere")
        .firewallRule(r -> r
            .direction(FirewallRule.Direction.IN)
            .protocol(FirewallRule.Protocol.ICMP)
            .sourceIP("0.0.0.0/0")
            .sourceIP("::/0")))
    .firewall();

Server server = api.servers().create(b -> b
        .name("my-server")
        .startAfterCreate(false)
        .serverType("cax11")
        .image("...")
        .datacenter("...")
        .firewall(firewall.id()))
    .server();
```

## Installation
[Installation guide for the latest release](https://github.com/litetex-oss/hetzner-cloud-client/releases/latest#Installation)

## Contributing
See the [contributing guide](./CONTRIBUTING.md) for detailed instructions on how to get started with our project.

## Dependencies and Licenses
View the [license of the current project](LICENSE) or the [summary including all dependencies](https://litetex-oss.github.io/hetzner-cloud-client/dependencies)
