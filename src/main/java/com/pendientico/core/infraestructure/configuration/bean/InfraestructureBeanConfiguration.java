package com.pendientico.core.infraestructure.configuration.bean;

import com.pendientico.core.domain.ports.UserPersistencePort;
import com.pendientico.core.domain.ports.WorkspaceContactPersistencePort;
import com.pendientico.core.domain.ports.WorkspaceMemberPersistencePort;
import com.pendientico.core.domain.ports.WorkspacePersistencePort;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.adapter.UserPersistenceJpaAdapter;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.adapter.WorkspaceContactJpaAdapter;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.adapter.WorkspaceMemberJpaAdapter;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.adapter.WorkspacePersistenceJpaAdapter;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.mapper.UserEntityMapper;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.mapper.WorkspaceContactEntityMapper;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.mapper.WorkspaceEntityMapper;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.mapper.WorkspaceMemberEntityMapper;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.repository.UserJpaRepository;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.repository.WorkspaceContactJpaRepository;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.repository.WorkspaceJpaRepository;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.repository.WorkspaceMemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class InfraestructureBeanConfiguration {
    private final UserJpaRepository userJpaRepository;
    private final WorkspaceJpaRepository workspaceJpaRepository;

    @Bean
    public UserPersistencePort userPersistencePort(UserEntityMapper userEntityMapper){
        return new UserPersistenceJpaAdapter(userJpaRepository, userEntityMapper);
    }

    @Bean
    public WorkspacePersistencePort workspacePersistencePort(WorkspaceEntityMapper workspaceEntityMapper){
        return new WorkspacePersistenceJpaAdapter(workspaceJpaRepository, workspaceEntityMapper);
    }

    @Bean
    public WorkspaceContactPersistencePort workspaceContactPersistencePort(WorkspaceContactJpaRepository workspaceContactJpaRepository,
                                                                           WorkspaceContactEntityMapper workspaceContactEntityMapper){
        return new WorkspaceContactJpaAdapter(workspaceContactJpaRepository, workspaceContactEntityMapper);
    }

    @Bean
    public WorkspaceMemberPersistencePort workspaceMemberPersistencePort(WorkspaceMemberJpaRepository workspaceMemberJpaRepository, WorkspaceMemberEntityMapper workspaceMemberEntityMapper){
        return new WorkspaceMemberJpaAdapter(workspaceMemberJpaRepository, workspaceMemberEntityMapper);
    }
}
