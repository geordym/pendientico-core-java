package com.pendientico.core.domain.usecases.workspaces;

import com.pendientico.core.domain.model.WorkspaceCollaboratorInvitationModel;
import com.pendientico.core.domain.ports.WorkspaceCollaboratorInvitationPersistencePort;
import com.pendientico.core.domain.values.enums.WorkspaceInvitation;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.UUID;

import static com.pendientico.core.domain.values.constants.GeneralConstants.EXPIRATION_SECONDS_WORKSPACE_INVITATION;

@RequiredArgsConstructor
public class CreateWorkspaceCollaboratorInvitationUseCase {

    private final WorkspaceCollaboratorInvitationPersistencePort workspaceCollaboratorInvitationPersistencePort;

    public UseCaseOutput procesar(UseCaseInput input) {
        var workspaceId = input.getWorkspaceId();
        var userId = input.getUserId();

        var invitationExpireTime = Instant.now().plusSeconds(EXPIRATION_SECONDS_WORKSPACE_INVITATION);

        var workspaceCollaboratorInvitationModel = WorkspaceCollaboratorInvitationModel.builder()
                .workspaceId(workspaceId)
                .userId(userId)
                .status(WorkspaceInvitation.PENDING.name())
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .expiresAt(invitationExpireTime)
                .build();

        var invitationCreated = workspaceCollaboratorInvitationPersistencePort.saveWorkspaceCollaboratorInvitation(workspaceCollaboratorInvitationModel);

        return UseCaseOutput.builder()
                .invitationId(invitationCreated.getId())
                .build();
    }

    @Builder
    @Getter
    public static class UseCaseInput {
        private UUID workspaceId;
        private UUID userId;
    }

    @Builder
    @Getter
    public static class UseCaseOutput {
        private UUID invitationId;
    }

}
