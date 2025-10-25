package com.pendientico.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class WorkspaceCollaboratorInvitationModel {
    private UUID id;
    private UUID workspaceId;
    private UUID userId;
    private String status;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant expiresAt;
}
