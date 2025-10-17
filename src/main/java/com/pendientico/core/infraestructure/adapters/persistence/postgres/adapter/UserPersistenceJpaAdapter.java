package com.pendientico.core.infraestructure.adapters.persistence.postgres.adapter;

import com.pendientico.core.domain.model.UserModel;
import com.pendientico.core.domain.ports.UserPersistencePort;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.entity.UserEntity;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.mapper.UserEntityMapper;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.repository.UserJpaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor
public class UserPersistenceJpaAdapter implements UserPersistencePort {
    private final UserJpaRepository userJpaRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    @Transactional
    public UserModel findOrCreateUserByProviderAuthUserId(UUID providerAuthUserId) {
        UserEntity user =  userJpaRepository.findByProviderAuthUserId(providerAuthUserId)
                .orElseGet(() -> {
                    UserEntity newUser = UserEntity.builder()
                            .providerAuthUserId(providerAuthUserId)
                            .createdAt(Instant.now())
                            .updatedAt(Instant.now())
                            .build();

                    return userJpaRepository.save(newUser);
                });

        return userEntityMapper.toModel(user);
    }

}
