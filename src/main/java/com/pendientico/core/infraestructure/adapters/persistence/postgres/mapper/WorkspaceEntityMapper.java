package com.pendientico.core.infraestructure.adapters.persistence.postgres.mapper;

import com.pendientico.core.domain.model.WorkspaceModel;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.entity.WorkspaceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkspaceEntityMapper {
    WorkspaceEntity toEntity(WorkspaceModel model);
    WorkspaceModel toModel(WorkspaceEntity entity);
}
