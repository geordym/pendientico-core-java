package com.pendientico.core.domain.usecases.workspaces;

import com.pendientico.core.domain.model.WorkspaceMemberModel;
import com.pendientico.core.domain.model.WorkspaceModel;
import com.pendientico.core.domain.ports.WorkspaceMemberPersistencePort;
import com.pendientico.core.domain.ports.WorkspacePersistencePort;
import com.pendientico.core.domain.values.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor
public class CreateWorkspaceUseCase {

    private final WorkspacePersistencePort workspacePersistencePort;
    private final WorkspaceMemberPersistencePort workspaceMemberPersistencePort;

    public UseCaseOutput procesar(UseCaseInput useCaseInput){
        var workspaceName = useCaseInput.getName();

        WorkspaceModel workspaceModel = WorkspaceModel.builder()
                .name(workspaceName)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();

        var workspaceSaved =  workspacePersistencePort.saveWorkspace(workspaceModel);

        var workspaceOwnerUserId = useCaseInput.getOwnerUserId();

        var workspaceMemberOwner = WorkspaceMemberModel.builder()
                .workspaceId(workspaceSaved.getId())
                .userId(workspaceOwnerUserId)
                .role(Role.OWNER.name())
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();

        workspaceMemberPersistencePort.saveWorkspaceMember(workspaceMemberOwner);

        return UseCaseOutput.builder()
                .workspaceId(workspaceSaved.getId())
                .build();
    }

    @Builder
    @Getter
    public static class UseCaseInput {
        private String name;
        private UUID ownerUserId;
    }

    @Builder
    @Getter
    public static class UseCaseOutput {
        private UUID workspaceId;
    }

}
