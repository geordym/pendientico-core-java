package com.pendientico.core.infraestructure.adapters.persistence.postgres.repository;

import com.pendientico.core.infraestructure.adapters.persistence.postgres.entity.WorkspaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceJpaRepository extends JpaRepository<WorkspaceEntity, String> {
}
