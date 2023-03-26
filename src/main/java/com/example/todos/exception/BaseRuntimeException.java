package com.example.todos.exception;

import com.example.todos.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;

public abstract class BaseRuntimeException extends RuntimeException {

    public BaseRuntimeException(String message) {
        super(message);
    }

    public abstract HttpStatus getStatus();

    public abstract String getCode();

    public ErrorResponseDto buildErrorResponse() {
        return ErrorResponseDto.builder()
                .code(this.getCode())
                .message(this.getMessage())
                .build();
    }
}
