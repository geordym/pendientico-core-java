package com.pendientico.core.infraestructure.adapters.persistence.postgres.repository;

import com.pendientico.core.infraestructure.adapters.persistence.postgres.entity.WorkspaceMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceMemberJpaRepository extends JpaRepository<WorkspaceMemberEntity, String> {
}
