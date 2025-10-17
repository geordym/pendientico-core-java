package com.pendientico.core.infraestructure.adapters.persistence.postgres.mapper;

import com.pendientico.core.domain.model.WorkspaceMemberModel;
import com.pendientico.core.domain.model.WorkspaceModel;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.entity.WorkspaceEntity;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.entity.WorkspaceMemberEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkspaceMemberEntityMapper {
    WorkspaceMemberEntity toEntity(WorkspaceMemberModel model);
    WorkspaceMemberModel toModel(WorkspaceMemberEntity entity);
}
