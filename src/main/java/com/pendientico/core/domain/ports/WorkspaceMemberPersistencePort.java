package com.pendientico.core.domain.ports;

import com.pendientico.core.domain.model.WorkspaceMemberModel;

public interface WorkspaceMemberPersistencePort {
    WorkspaceMemberModel saveWorkspaceMember(WorkspaceMemberModel workspaceMemberModel);
}
