package com.pendientico.core.domain.ports;

import com.pendientico.core.domain.model.WorkspaceContactModel;

public interface WorkspaceContactPersistencePort {
    WorkspaceContactModel saveWorkspaceContact(WorkspaceContactModel workspaceContactModel);
}
