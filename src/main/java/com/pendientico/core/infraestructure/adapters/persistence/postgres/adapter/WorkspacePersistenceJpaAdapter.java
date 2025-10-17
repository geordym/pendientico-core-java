package com.pendientico.core.infraestructure.adapters.persistence.postgres.adapter;

import com.pendientico.core.domain.model.WorkspaceModel;
import com.pendientico.core.domain.ports.WorkspacePersistencePort;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.entity.WorkspaceEntity;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.mapper.WorkspaceEntityMapper;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.repository.WorkspaceJpaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkspacePersistenceJpaAdapter implements WorkspacePersistencePort {

    private final WorkspaceJpaRepository workspaceJpaRepository;
    private final WorkspaceEntityMapper workspaceEntityMapper;

    @Override
    public WorkspaceModel saveWorkspace(WorkspaceModel workspaceModel) {
        WorkspaceEntity workspaceEntity = workspaceEntityMapper.toEntity(workspaceModel);
        WorkspaceEntity workspaceCreated = workspaceJpaRepository.save(workspaceEntity);
        return workspaceEntityMapper.toModel(workspaceCreated);
    }

}
