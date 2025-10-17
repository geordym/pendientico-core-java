package com.pendientico.core.domain.ports;

import java.util.Optional;
import java.util.UUID;

public interface UserAuthProviderPort {
    Optional<UUID> getProviderAuthUserId();

}
