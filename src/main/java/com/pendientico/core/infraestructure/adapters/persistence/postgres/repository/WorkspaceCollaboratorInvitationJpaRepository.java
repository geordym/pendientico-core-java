package com.pendientico.core.infraestructure.adapters.persistence.postgres.repository;

import com.pendientico.core.infraestructure.adapters.persistence.postgres.entity.WorkspaceCollaboratorInvitationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkspaceCollaboratorInvitationJpaRepository extends JpaRepository<WorkspaceCollaboratorInvitationEntity, UUID> {
}
