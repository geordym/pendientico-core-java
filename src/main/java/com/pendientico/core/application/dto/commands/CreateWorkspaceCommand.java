package com.pendientico.core.application.dto.commands;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateWorkspaceCommand {
    private String workspaceName;
}
