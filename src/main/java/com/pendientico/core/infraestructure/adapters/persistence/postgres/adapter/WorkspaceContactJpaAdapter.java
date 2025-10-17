package com.pendientico.core.infraestructure.adapters.persistence.postgres.adapter;

import com.pendientico.core.domain.model.WorkspaceContactModel;
import com.pendientico.core.domain.ports.WorkspaceContactPersistencePort;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.entity.WorkspaceContactEntity;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.mapper.WorkspaceContactEntityMapper;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.repository.WorkspaceContactJpaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkspaceContactJpaAdapter implements WorkspaceContactPersistencePort {

    private final WorkspaceContactJpaRepository workspaceContactJpaRepository;
    private final WorkspaceContactEntityMapper workspaceContactEntityMapper;

    @Override
    public WorkspaceContactModel saveWorkspaceContact(WorkspaceContactModel workspaceContactModel) {
        WorkspaceContactEntity workspaceContactEntity = workspaceContactEntityMapper.toEntity(workspaceContactModel);
        WorkspaceContactEntity workspaceContactSaved = workspaceContactJpaRepository.save(workspaceContactEntity);
        return workspaceContactEntityMapper.toModel(workspaceContactSaved);
    }

}
