package com.pendientico.core.domain.usecases.user.querys;

import com.pendientico.core.domain.ports.UserAuthProviderPort;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class GetUserInfoByUserIdUseCase {

    private final UserAuthProviderPort userAuthProviderPort;


    public UseCaseOutput procesar(UseCaseInput input) {
        var email = input.getEmail();


    }

    @Builder
    @Getter
    public static class UseCaseInput {
        private UUID email;
    }

    @Builder
    @Getter
    public static class UseCaseOutput {
        private String userId;
        private String providerAuthUserId;
    }

}
