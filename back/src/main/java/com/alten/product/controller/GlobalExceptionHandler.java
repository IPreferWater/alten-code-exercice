package com.alten.product.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        // Check if the exception message or cause indicates a unique constraint violation
        if (ex.getMessage().contains("unique constraint") || (ex.getCause() != null && ex.getCause().getMessage().contains("unique constraint"))) {
            // Handle unique constraint violation
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Duplicate key value violates unique constraint");
        }

        // Handle other data integrity violations
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data integrity violation");
    }
}