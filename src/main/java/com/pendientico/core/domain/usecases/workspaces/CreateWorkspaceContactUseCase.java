package com.pendientico.core.domain.usecases.workspaces;

import com.pendientico.core.domain.model.WorkspaceContactModel;
import com.pendientico.core.domain.ports.WorkspaceContactPersistencePort;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor
public class CreateWorkspaceContactUseCase {

    private final WorkspaceContactPersistencePort workspaceContactPersistencePort;


    public UseCaseOutput procesar(UseCaseInput input) {
        var contactName = input.getContactName();


        var workspaceContact = WorkspaceContactModel.builder()
                .workspaceId(input.getWorkspaceId())
                .name(contactName)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();

        var contactCreated = workspaceContactPersistencePort.saveWorkspaceContact(workspaceContact);

        return UseCaseOutput.builder()
                .contactId(contactCreated.getId())
                .build();
    }

    @Builder
    @Getter
    public static class UseCaseInput {
        private String contactName;
        private UUID workspaceId;
    }

    @Builder
    @Getter
    public static class UseCaseOutput {
        private UUID contactId;
    }

}
