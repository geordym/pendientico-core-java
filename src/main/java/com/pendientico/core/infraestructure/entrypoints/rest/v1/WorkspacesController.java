package com.pendientico.core.infraestructure.entrypoints.rest.v1;

import com.pendientico.core.application.dto.commands.CreateWorkspaceContactCommand;
import com.pendientico.core.application.dto.commands.InviteCollaboratorToWorkspaceCommand;
import com.pendientico.core.application.handlers.WorkspacesHandler;
import com.pendientico.core.application.dto.commands.CreateWorkspaceCommand;
import com.pendientico.core.infraestructure.entrypoints.rest.v1.dto.CreateWorkspaceContactRequestDTO;
import com.pendientico.core.infraestructure.entrypoints.rest.v1.dto.CreateWorkspaceRequestDTO;
import com.pendientico.core.infraestructure.entrypoints.rest.v1.dto.InviteCollaboratorRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/workspaces")
@RequiredArgsConstructor
public class WorkspacesController {

    private final WorkspacesHandler workspacesHandler;

    @PostMapping
    public ResponseEntity<CreateWorkspaceCommand.Output> createWorkspace(@RequestBody CreateWorkspaceRequestDTO createWorkspaceRequestDTO){
        CreateWorkspaceCommand.Input command = new CreateWorkspaceCommand.Input(createWorkspaceRequestDTO.getWorkspaceName());
        CreateWorkspaceCommand.Output createWorkspaceCommandOutput = workspacesHandler.createWorkspace(command);
        return ResponseEntity.ok().body(createWorkspaceCommandOutput);
    }

    @PostMapping("/{workspaceId}/contacts")
    public ResponseEntity<CreateWorkspaceContactCommand.Output> createWorkspaceContact(@PathVariable UUID workspaceId, @RequestBody CreateWorkspaceContactRequestDTO createWorkspaceContactRequestDTO){
        CreateWorkspaceContactCommand.Input command = new CreateWorkspaceContactCommand.Input(workspaceId, createWorkspaceContactRequestDTO.getClientName());
        CreateWorkspaceContactCommand.Output createWorkspaceContactOutput = workspacesHandler.createWorkspaceContact(command);
        return ResponseEntity.ok().body(createWorkspaceContactOutput);
    }


    @PostMapping("/{workspaceId}/invite-collabrator")
    public ResponseEntity<InviteCollaboratorToWorkspaceCommand.Output> inviteCollaborator(@PathVariable UUID workspaceId, @RequestBody InviteCollaboratorRequestDTO inviteCollaboratorRequestDTO){
        InviteCollaboratorToWorkspaceCommand.Input command = new InviteCollaboratorToWorkspaceCommand.Input(workspaceId, inviteCollaboratorRequestDTO.getEmail());
        InviteCollaboratorToWorkspaceCommand.Output output = workspacesHandler.inviteCollaborator(command);
        return ResponseEntity.ok().body(output);
    }



}
