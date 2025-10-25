package com.pendientico.core.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthenticationProviderInfoDTO {
    private String providerAuthUserId;
    private String userId;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private boolean emailVerified;
    private boolean enabled;
    private Instant createdAt;
    private Map<String, Object> attributes;
    private List<String> roles;
}
