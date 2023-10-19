package com.precizeassignment.exception;

import com.precizeassignment.dto.ApplicationErrorResponse;
import jakarta.validation.ValidationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApplicationErrorResponse> handleRuntimeException(RuntimeException ex) {
        ApplicationErrorResponse errorResponse = new ApplicationErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApplicationErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        ApplicationErrorResponse errorResponse = new ApplicationErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatusCode(HttpStatus.CONFLICT.value());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApplicationErrorResponse> handleValidationException(ValidationException e){
        ApplicationErrorResponse errorResponse = new ApplicationErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<ApplicationErrorResponse> handleGenericException(Exception e){
        final ApplicationErrorResponse errorResponse = new ApplicationErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
