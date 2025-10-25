package com.pendientico.core.application.dto.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class InviteCollaboratorToWorkspaceCommand {

    @Data
    @AllArgsConstructor
    public static class Input{
        private UUID workspaceId;
        private String invitedEmail;

    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class Output{
        private UUID invitationId;
    }
}
