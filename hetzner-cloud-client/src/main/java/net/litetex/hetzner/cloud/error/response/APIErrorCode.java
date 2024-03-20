package net.litetex.hetzner.cloud.error.response;

public final class APIErrorCode
{
    // General error codes
    public static final String FORBIDDEN = "forbidden";
    public static final String INVALID_INPUT = "invalid_input";
    public static final String JSON_ERROR = "json_error";
    public static final String LOCKED = "locked";
    public static final String NOT_FOUND = "not_found";
    public static final String RATE_LIMIT_EXCEEDED = "rate_limit_exceeded";
    public static final String RESOURCE_LIMIT_EXCEEDED = "resource_limit_exceeded";
    public static final String RESOURCE_UNAVAILABLE = "resource_unavailable";
    public static final String SERVICE_ERROR = "service_error";
    public static final String UNIQUENESS_ERROR = "uniqueness_error";
    public static final String PROTECTED = "protected";
    public static final String MAINTENANCE = "maintenance";
    public static final String CONFLICT = "conflict";
    public static final String UNSUPPORTED_ERROR = "unsupported_error";
    public static final String TOKEN_READONLY = "token_readonly";
    
    // Certificate related
    public static final String CAA_RECORD_DOES_NOT_ALLOW_CA = "caa_record_does_not_allow_ca";
    public static final String CA_DNS_VALIDATION_FAILED = "ca_dns_validation_failed";
    public static final String CA_TOO_MANY_AUTHORIZATIONS_FAILED_RECENTLY =
        "ca_too_many_authorizations_failed_recently";
    public static final String CA_TOO_MANY_CERTIFICATES_ISSUED_FOR_REGISTERED_DOMAIN =
        "ca_too_many_certificates_issued_for_registered_domain";
    public static final String CA_TOO_MANY_DUPLICATE_CERTIFICATES = "ca_too_many_duplicate_certificates";
    public static final String COULD_NOT_VERIFY_DOMAIN_DELEGATED_TO_ZONE = "could_not_verify_domain_delegated_to_zone";
    public static final String DNS_ZONE_NOT_FOUND = "dns_zone_not_found";
    public static final String DNS_ZONE_IS_SECONDARY_ZONE = "dns_zone_is_secondary_zone";
    
    // Firewall related
    public static final String SERVER_ALREADY_ADDED = "server_already_added";
    public static final String INCOMPATIBLE_NETWORK_TYPE = "incompatible_network_type";
    public static final String FIREWALL_RESOURCE_NOT_FOUND = "firewall_resource_not_found";
    public static final String RESOURCE_IN_USE = "resource_in_use";
    public static final String FIREWALL_ALREADY_APPLIED = "firewall_already_applied";
    public static final String FIREWALL_ALREADY_REMOVED = "firewall_already_removed";
    public static final String FIREWALL_MANAGED_BY_LABEL_SELECTOR = "firewall_managed_by_label_selector";
    
    // Load Balancer related
    public static final String CLOUD_RESOURCE_IP_NOT_ALLOWED = "cloud_resource_ip_not_allowed";
    public static final String IP_NOT_OWNED = "ip_not_owned";
    public static final String LOAD_BALANCER_NOT_ATTACHED_TO_NETWORK = "load_balancer_not_attached_to_network";
    public static final String ROBOT_UNAVAILABLE = "robot_unavailable";
    public static final String SERVER_NOT_ATTACHED_TO_NETWORK = "server_not_attached_to_network";
    public static final String SOURCE_PORT_ALREADY_USED = "source_port_already_used";
    public static final String TARGET_ALREADY_DEFINED = "target_already_defined";
    public static final String LOAD_BALANCER_ALREADY_ATTACHED = "load_balancer_already_attached";
    public static final String IP_NOT_AVAILABLE = "ip_not_available";
    public static final String NO_SUBNET_AVAILABLE = "no_subnet_available";
    public static final String INVALID_LOAD_BALANCER_TYPE = "invalid_load_balancer_type";
    public static final String TARGETS_WITHOUT_USE_PRIVATE_IP = "targets_without_use_private_ip";
    
    // Primary IP related
    public static final String SERVER_NOT_STOPPED = "server_not_stopped";
    public static final String SERVER_HAS_IPV4 = "server_has_ipv4";
    public static final String SERVER_HAS_IPV6 = "server_has_ipv6";
    public static final String PRIMARY_IP_ALREADY_ASSIGNED = "primary_ip_already_assigned";
    public static final String SERVER_IS_LOAD_BALANCER_TARGET = "server_is_load_balancer_target";
    public static final String SERVER_ERROR = "server_error";
    
    // Server related
    public static final String PLACEMENT_ERROR = "placement_error";
    public static final String PRIMARY_IP_ASSIGNED = "primary_ip_assigned";
    public static final String PRIMARY_IP_DATACENTER_MISMATCH = "primary_ip_datacenter_mismatch";
    public static final String PRIMARY_IP_VERSION_MISMATCH = "primary_ip_version_mismatch";
    public static final String SERVER_ALREADY_ATTACHED = "server_already_attached";
    public static final String NETWORKS_OVERLAP = "networks_overlap";
    public static final String INVALID_SERVER_TYPE = "invalid_server_type";
    
    // Volume related
    public static final String NO_SPACE_LEFT_IN_LOCATION = "no_space_left_in_location";
    
    private APIErrorCode()
    {
    }
}
