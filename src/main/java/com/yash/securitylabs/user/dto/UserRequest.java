package com.yash.securitylabs.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequest(
        @Email
        @NotBlank
        String email,
        @NotBlank
        @NotNull
        String password
) {
}
