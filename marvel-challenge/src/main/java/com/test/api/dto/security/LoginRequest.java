package com.test.api.dto.security;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank String username ,
        @NotBlank String password
) {
}
