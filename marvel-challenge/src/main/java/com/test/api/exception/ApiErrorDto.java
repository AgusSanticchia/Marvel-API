package com.test.api.exception;

public record ApiErrorDto(
        String message,
        String backendMessage,
        String method,
        String url
) {
}