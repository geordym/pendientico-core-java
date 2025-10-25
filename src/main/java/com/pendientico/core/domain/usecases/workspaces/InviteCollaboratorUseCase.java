package com.pendientico.core.domain.usecases.workspaces;


import com.pendientico.core.domain.model.WorkspaceMemberModel;
import com.pendientico.core.domain.model.WorkspaceModel;
import com.pendientico.core.domain.values.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor
public class InviteCollaboratorUseCase {

    public UseCaseOutput procesar(UseCaseInput useCaseInput){



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
