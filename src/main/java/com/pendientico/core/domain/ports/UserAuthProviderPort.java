package com.pendientico.core.domain.ports;

import com.pendientico.core.domain.dto.UserAuthenticationProviderInfoDTO;

import java.util.Optional;
import java.util.UUID;

public interface UserAuthProviderPort {
    Optional<UUID> getProviderAuthUserId();
    UserAuthenticationProviderInfoDTO getUserProviderInfo(String providerAuthUserId);
}
