package com.pendientico.core.application.handlers;

import com.pendientico.core.application.dto.commands.CreateWorkspaceCommand;
import com.pendientico.core.application.dto.output.CreateWorkspaceOutput;
import com.pendientico.core.domain.model.UserModel;
import com.pendientico.core.domain.ports.UserAuthProviderPort;
import com.pendientico.core.domain.ports.UserPersistencePort;
import com.pendientico.core.domain.usecases.workspaces.CreateWorkspaceUseCase;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class WorkspacesHandler {

    private final CreateWorkspaceUseCase createWorkspaceUseCase;
    private final UserAuthProviderPort userAuthProviderPort;
    private final UserPersistencePort userPersistencePort;

    public CreateWorkspaceOutput createWorkspace(CreateWorkspaceCommand createWorkspaceCommand){
        UUID providerAuthUserId = userAuthProviderPort.getProviderAuthUserId().orElseThrow();
        UserModel userAuthenticated = userPersistencePort.findOrCreateUserByProviderAuthUserId(providerAuthUserId);
        UUID userId = userAuthenticated.getId();
        String workspaceName = createWorkspaceCommand.getWorkspaceName();

        CreateWorkspaceUseCase.UseCaseInput useCaseInput = CreateWorkspaceUseCase.UseCaseInput.builder()
                .ownerUserId(userId)
                .name(workspaceName)
                .build();

        CreateWorkspaceUseCase.UseCaseOutput useCaseOutput = createWorkspaceUseCase.procesar(useCaseInput);

        return CreateWorkspaceOutput.builder()
                .workspaceId(useCaseOutput.getWorkspaceId())
                .build();
    }

}
