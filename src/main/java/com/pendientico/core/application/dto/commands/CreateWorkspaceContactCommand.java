package com.pendientico.core.application.dto.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CreateWorkspaceContactCommand {

    @Data
    @AllArgsConstructor
    public static class Input {
        private UUID workspaceId;
        private String clientName;
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class Output{
        private UUID contactId;
    }

}
