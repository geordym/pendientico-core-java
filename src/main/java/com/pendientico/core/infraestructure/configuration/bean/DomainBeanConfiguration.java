package com.pendientico.core.infraestructure.configuration.bean;

import com.pendientico.core.domain.ports.UserAuthProviderPort;
import com.pendientico.core.domain.ports.WorkspaceMemberPersistencePort;
import com.pendientico.core.domain.ports.WorkspacePersistencePort;
import com.pendientico.core.domain.usecases.workspaces.CreateWorkspaceUseCase;
import com.pendientico.core.infraestructure.adapters.auth.UserAuthProviderAdapterImpl;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.adapter.WorkspacePersistenceJpaAdapter;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.mapper.WorkspaceEntityMapper;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.repository.WorkspaceJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainBeanConfiguration {

    @Bean
    public CreateWorkspaceUseCase createWorkspaceUseCase(WorkspacePersistencePort workspacePersistencePort, WorkspaceMemberPersistencePort workspaceMemberPersistencePort){
        return new CreateWorkspaceUseCase(workspacePersistencePort, workspaceMemberPersistencePort);
    }

    @Bean
    public UserAuthProviderPort userAuthProviderPort(){
        return new UserAuthProviderAdapterImpl();
    }

    @Bean
    public WorkspacePersistencePort workspacePersistenceAdapter(WorkspaceJpaRepository workspaceJpaRepository, WorkspaceEntityMapper workspaceEntityMapper){
        return new WorkspacePersistenceJpaAdapter(workspaceJpaRepository, workspaceEntityMapper);
    }


}

