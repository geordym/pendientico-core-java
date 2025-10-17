package com.pendientico.core.infraestructure.adapters.persistence.postgres.adapter;

import com.pendientico.core.domain.model.WorkspaceMemberModel;
import com.pendientico.core.domain.ports.WorkspaceMemberPersistencePort;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.entity.WorkspaceMemberEntity;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.mapper.WorkspaceMemberEntityMapper;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.repository.WorkspaceMemberJpaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WorkspaceMemberJpaAdapter implements WorkspaceMemberPersistencePort {

    private final WorkspaceMemberJpaRepository workspaceMemberJpaRepository;
    private final WorkspaceMemberEntityMapper workspaceMemberEntityMapper;

    @Override
    public WorkspaceMemberModel saveWorkspaceMember(WorkspaceMemberModel workspaceMemberModel) {
        WorkspaceMemberEntity workspaceMemberEntity = workspaceMemberEntityMapper.toEntity(workspaceMemberModel);
        WorkspaceMemberEntity workspaceMemberSaved = workspaceMemberJpaRepository.save(workspaceMemberEntity);
        return workspaceMemberEntityMapper.toModel(workspaceMemberSaved);
    }
}
