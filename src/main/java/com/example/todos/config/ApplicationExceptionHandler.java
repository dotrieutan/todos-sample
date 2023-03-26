package com.example.todos.config;

import com.example.todos.dto.ErrorResponseDto;
import com.example.todos.exception.DataNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleDataNotFoundException(
            DataNotFoundException exception,
            WebRequest request) {
        return ResponseEntity
                .status(exception.getStatus())
                .body(exception.buildErrorResponse());
    }
}
