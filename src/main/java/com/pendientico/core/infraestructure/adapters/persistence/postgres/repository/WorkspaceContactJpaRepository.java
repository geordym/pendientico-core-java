package com.pendientico.core.infraestructure.adapters.persistence.postgres.repository;

import com.pendientico.core.infraestructure.adapters.persistence.postgres.entity.WorkspaceContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceContactJpaRepository extends JpaRepository<WorkspaceContactEntity, String> {
}
