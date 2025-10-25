package com.pendientico.core.infraestructure.adapters.persistence.postgres.mapper;

import com.pendientico.core.domain.model.WorkspaceCollaboratorInvitationModel;
import com.pendientico.core.domain.model.WorkspaceContactModel;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.entity.WorkspaceCollaboratorInvitationEntity;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.entity.WorkspaceContactEntity;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface WorkspaceCollaboratorInvitationEntityMapper {
    WorkspaceCollaboratorInvitationEntity toEntity(WorkspaceCollaboratorInvitationModel model);
    WorkspaceCollaboratorInvitationModel toModel(WorkspaceCollaboratorInvitationEntity entity);
}
