package com.pendientico.core.infraestructure.adapters.auth;

import com.pendientico.core.domain.ports.UserAuthProviderPort;
import com.pendientico.core.infraestructure.adapters.auth.config.KeycloakProperties;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.UserRepresentation;

@RequiredArgsConstructor
public class KeycloakAdminService {

    private final Keycloak keycloak;
    private final KeycloakProperties properties;
    private final UserAuthProviderPort userAuthProviderPort;


    public UserRepresentation getUserById(String userId) {
        String realm = properties.getRealm();
        UserResource userResource = keycloak.realm(realm).users().get(userId);
        return userResource.toRepresentation();
    }
}