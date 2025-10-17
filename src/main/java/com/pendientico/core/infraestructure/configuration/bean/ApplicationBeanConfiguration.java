package com.pendientico.core.infraestructure.configuration.bean;

import com.pendientico.core.application.handlers.WorkspacesHandler;
import com.pendientico.core.domain.ports.UserAuthProviderPort;
import com.pendientico.core.domain.ports.UserPersistencePort;
import com.pendientico.core.domain.usecases.workspaces.CreateWorkspaceUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ApplicationBeanConfiguration {

    private final CreateWorkspaceUseCase createWorkspaceUseCase;
    private final UserAuthProviderPort userAuthProviderPort;
    private final UserPersistencePort userPersistencePort;

    @Bean
    public WorkspacesHandler workspacesHandler(){
        return new WorkspacesHandler(createWorkspaceUseCase, userAuthProviderPort, userPersistencePort);
    }



}
