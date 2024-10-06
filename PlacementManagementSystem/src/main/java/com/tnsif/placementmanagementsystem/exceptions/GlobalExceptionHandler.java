package com.tnsif.placementmanagementsystem.exceptions;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for the application.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles EntityNotFoundException.
     *
     * @param ex the exception
     * @return response entity with error message and HTTP status
     */
//    @ExceptionHandler(EntityNotFoundException.class)
//    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException ex) {
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//    }


}
