package com.pendientico.core.application.handlers;

import com.pendientico.core.application.dto.commands.CreateWorkspaceCommand;
import com.pendientico.core.application.dto.commands.CreateWorkspaceContactCommand;
import com.pendientico.core.application.dto.commands.InviteCollaboratorToWorkspaceCommand;
import com.pendientico.core.application.dto.commands.output.CreateWorkspaceContactCommandOutput;
import com.pendientico.core.application.dto.commands.output.CreateWorkspaceCommandOutput;
import com.pendientico.core.application.dto.commands.output.InviteCollaboratorToWorkspaceCommandOutput;
import com.pendientico.core.domain.model.UserModel;
import com.pendientico.core.domain.ports.UserAuthProviderPort;
import com.pendientico.core.domain.ports.UserPersistencePort;
import com.pendientico.core.domain.usecases.workspaces.CreateWorkspaceContactUseCase;
import com.pendientico.core.domain.usecases.workspaces.InviteCollaboratorUseCase;
import com.pendientico.core.domain.usecases.workspaces.CreateWorkspaceUseCase;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class WorkspacesHandler {

    private final UserAuthProviderPort userAuthProviderPort;
    private final UserPersistencePort userPersistencePort;
    private final CreateWorkspaceUseCase createWorkspaceUseCase;
    private final CreateWorkspaceContactUseCase createWorkspaceContactUseCase;

    public CreateWorkspaceCommand.Output createWorkspace(CreateWorkspaceCommand.Input command){
        UUID providerAuthUserId = userAuthProviderPort.getProviderAuthUserId().orElseThrow();
        UserModel userAuthenticated = userPersistencePort.findOrCreateUserByProviderAuthUserId(providerAuthUserId);
        UUID userId = userAuthenticated.getId();
        String workspaceName = command.getWorkspaceName();

        CreateWorkspaceUseCase.UseCaseInput useCaseInput = CreateWorkspaceUseCase.UseCaseInput.builder()
                .ownerUserId(userId)
                .name(workspaceName)
                .build();

        CreateWorkspaceUseCase.UseCaseOutput useCaseOutput = createWorkspaceUseCase.procesar(useCaseInput);

        return CreateWorkspaceCommand.Output.builder()
                .workspaceId(useCaseOutput.getWorkspaceId())
                .build();
    }

    public CreateWorkspaceContactCommand.Output createWorkspaceContact(CreateWorkspaceContactCommand.Input command){
        var workspaceId = command.getWorkspaceId();
        var contactName = command.getClientName();

        CreateWorkspaceContactUseCase.UseCaseInput usecaseInput = CreateWorkspaceContactUseCase.UseCaseInput.builder()
                .workspaceId(workspaceId)
                .contactName(contactName)
                .build();

        var usecaseOutput = createWorkspaceContactUseCase.procesar(usecaseInput);

        return CreateWorkspaceContactCommand.Output.builder()
                .contactId(usecaseOutput.getContactId())
                .build();
    }

    public InviteCollaboratorToWorkspaceCommand.Output inviteCollaborator(InviteCollaboratorToWorkspaceCommand.Input command){


        InviteCollaboratorUseCase.UseCaseInput input = InviteCollaboratorUseCase.UseCaseInput.builder()
                .userId()
                .workspaceId()
                .build();


        return InviteCollaboratorToWorkspaceCommand.Output.builder().build();
    }

}
