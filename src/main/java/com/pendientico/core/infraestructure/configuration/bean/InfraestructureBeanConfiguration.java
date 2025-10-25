package com.pendientico.core.infraestructure.configuration.bean;

import com.pendientico.core.domain.ports.*;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.adapter.*;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.mapper.*;
import com.pendientico.core.infraestructure.adapters.persistence.postgres.repository.*;
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

    @Bean
    public WorkspaceCollaboratorInvitationPersistencePort workspaceCollaboratorInvitationPersistencePort(WorkspaceCollaboratorInvitationJpaRepository workspaceCollaboratorInvitationJpaRepository, WorkspaceCollaboratorInvitationEntityMapper workspaceCollaboratorInvitationEntityMapper){
        return new WorkspaceCollaboratorInvitationJpaAdapter(workspaceCollaboratorInvitationJpaRepository, workspaceCollaboratorInvitationEntityMapper);
    }
}
