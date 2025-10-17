package com.pendientico.core.domain.ports;

import com.pendientico.core.domain.model.UserModel;

import java.util.UUID;

public interface UserPersistencePort {
    UserModel findOrCreateUserByProviderAuthUserId(UUID providerAuthUserId);
}
