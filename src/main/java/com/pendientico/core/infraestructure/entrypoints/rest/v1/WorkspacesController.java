package com.pendientico.core.infraestructure.entrypoints.rest.v1;

import com.pendientico.core.application.handlers.WorkspacesHandler;
import com.pendientico.core.application.dto.commands.CreateWorkspaceCommand;
import com.pendientico.core.application.dto.output.CreateWorkspaceOutput;
import com.pendientico.core.infraestructure.entrypoints.rest.v1.dto.CreateWorkspaceRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/workspaces")
@RequiredArgsConstructor
public class WorkspacesController {

    private final WorkspacesHandler workspacesHandler;

    @PostMapping
    public ResponseEntity<CreateWorkspaceOutput> createWorkspace(@RequestBody CreateWorkspaceRequestDTO createWorkspaceRequestDTO){
        CreateWorkspaceCommand command = new CreateWorkspaceCommand(createWorkspaceRequestDTO.getWorkspaceName());
        CreateWorkspaceOutput createWorkspaceOutput = workspacesHandler.createWorkspace(command);
        return ResponseEntity.ok().body(createWorkspaceOutput);
    }


}
