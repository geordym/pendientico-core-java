package com.pendientico.core.infraestructure.adapters.persistence.postgres.repository;

import com.pendientico.core.infraestructure.adapters.persistence.postgres.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByProviderAuthUserId(UUID providerAuthUserId);
}
