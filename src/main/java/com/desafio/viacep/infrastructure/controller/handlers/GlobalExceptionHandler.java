package com.desafio.viacep.infrastructure.controller.handlers;

import com.desafio.viacep.business.exception.ResourceNotFoundException;
import com.desafio.viacep.infrastructure.controller.models.ErrorResponse;
import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;
import static org.springframework.http.ResponseEntity.status;
import static org.springframework.http.ResponseEntity.unprocessableEntity;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourceNotFoundException(final ResourceNotFoundException e) {
        final var errorResponse = new ErrorResponse(NOT_FOUND.value(), new Date(), e.getMessage());
        return status(NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> validationException(final ValidationException e) {
        final var errorResponse = new ErrorResponse(UNPROCESSABLE_ENTITY.value(), new Date(), e.getMessage());
        return unprocessableEntity().body(errorResponse);
    }

}