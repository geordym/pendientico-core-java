package com.pendientico.core.domain.ports;

import com.pendientico.core.domain.model.WorkspaceCollaboratorInvitationModel;

public interface WorkspaceCollaboratorInvitationPersistencePort {
    WorkspaceCollaboratorInvitationModel saveWorkspaceCollaboratorInvitation(WorkspaceCollaboratorInvitationModel model);
}
