package com.pendientico.core.infraestructure.adapters.auth;

import com.pendientico.core.domain.ports.UserAuthProviderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class UserAuthProviderAdapterImpl implements UserAuthProviderPort {

    @Override
    public Optional<UUID> getProviderAuthUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof Jwt jwt) {
            String sub = jwt.getClaimAsString("sub");
            return Optional.of(UUID.fromString(sub));
        }

        return Optional.empty();
    }

}
