package com.pendientico.core.application.dto.output;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateWorkspaceOutput(UUID workspaceId) {
}
