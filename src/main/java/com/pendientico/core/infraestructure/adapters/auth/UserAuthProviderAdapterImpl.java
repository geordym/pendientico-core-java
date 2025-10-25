

package com.pendientico.core.infraestructure.adapters.auth;

import com.pendientico.core.domain.dto.UserAuthenticationProviderInfoDTO;
import com.pendientico.core.domain.ports.UserAuthProviderPort;
import lombok.RequiredArgsConstructor;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class UserAuthProviderAdapterImpl implements UserAuthProviderPort {

    private final KeycloakAdminService keycloakAdminService;

    @Override
    public Optional<UUID> getProviderAuthUserId() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof Jwt jwt) {
            String sub = jwt.getClaimAsString("sub");
            return Optional.of(UUID.fromString(sub));
        }

        return Optional.empty();
    }

    @Override
    public UserAuthenticationProviderInfoDTO getUserProviderInfo(String providerAuthUserId) {
        UserRepresentation userRepresentation = keycloakAdminService.getUserById(providerAuthUserId);
        return UserAuthenticationProviderInfoDTO.builder().build();
    }

}
