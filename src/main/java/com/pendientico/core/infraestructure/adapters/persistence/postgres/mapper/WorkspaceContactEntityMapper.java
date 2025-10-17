package com.pendientico.core.infraestructure.adapters.persistence.postgres.mapper;

import com.pendientico.core.domain.model.WorkspaceContactModel;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.entity.WorkspaceContactEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkspaceContactEntityMapper {
    WorkspaceContactEntity toEntity(WorkspaceContactModel model);
    WorkspaceContactModel toModel(WorkspaceContactEntity entity);
}
