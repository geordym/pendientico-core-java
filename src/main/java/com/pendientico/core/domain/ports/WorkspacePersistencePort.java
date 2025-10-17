package com.pendientico.core.domain.ports;

import com.pendientico.core.domain.model.WorkspaceModel;

public interface WorkspacePersistencePort {
    WorkspaceModel saveWorkspace(WorkspaceModel workspaceModel);
}
