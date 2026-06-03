package com.codingshuttle.studentmanagement.advices;

import com.codingshuttle.studentmanagement.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex) {
    return  ResponseEntity.badRequest().body(ApiResponse.builder()
            .error(ApiError.builder()
                    .message(ex.getMessage())
                    .build())
            .build());
    }

    public ResponseEntity<?> handleException(Exception ex){

    return ResponseEntity.badRequest().body(ApiResponse.builder()
            .error(ApiError.builder()
                    .message(ex.getMessage())
                    .build())
            .build());
    }
}
