package com.pendientico.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;
import java.util.UUID;


@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private UUID id;
    private UUID providerAuthUserId;
    private Instant createdAt;
    private Instant updatedAt;
}
