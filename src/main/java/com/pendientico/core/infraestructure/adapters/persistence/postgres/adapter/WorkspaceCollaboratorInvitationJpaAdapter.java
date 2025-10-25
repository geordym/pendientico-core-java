package com.pendientico.core.infraestructure.adapters.persistence.postgres.adapter;

import com.pendientico.core.domain.model.WorkspaceCollaboratorInvitationModel;
import com.pendientico.core.domain.ports.WorkspaceCollaboratorInvitationPersistencePort;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.entity.WorkspaceCollaboratorInvitationEntity;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.mapper.WorkspaceCollaboratorInvitationEntityMapper;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.repository.WorkspaceCollaboratorInvitationJpaRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class WorkspaceCollaboratorInvitationJpaAdapter implements WorkspaceCollaboratorInvitationPersistencePort {

    private final WorkspaceCollaboratorInvitationJpaRepository workspaceCollaboratorInvitationJpaRepository;
    private final WorkspaceCollaboratorInvitationEntityMapper workspaceCollaboratorInvitationEntityMapper;

    @Override
    public WorkspaceCollaboratorInvitationModel saveWorkspaceCollaboratorInvitation(WorkspaceCollaboratorInvitationModel model) {
        WorkspaceCollaboratorInvitationEntity entity = workspaceCollaboratorInvitationEntityMapper.toEntity(model);
        WorkspaceCollaboratorInvitationEntity saved = workspaceCollaboratorInvitationJpaRepository.save(entity);
        return workspaceCollaboratorInvitationEntityMapper.toModel(saved);
    }

}
