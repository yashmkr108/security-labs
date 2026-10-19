package com.yash.securitylabs.user.dto;

import java.time.Instant;

public record UserResponse(
        int status,
        Long id,
        String email,
        Instant timestamp
) {
}
