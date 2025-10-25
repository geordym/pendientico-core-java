package com.pendientico.core.infraestructure.adapters.auth.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "keycloak")
public class KeycloakProperties {
    private String url;
    private String realm;
    private String clientId;
    private String clientSecret;
}