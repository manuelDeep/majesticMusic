package org.majestic.majesticMusic.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Method to handle HttpException globally
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResponseEntity<Object> handleHttpException(BusinessException ex) {
        // Create an error response with details from the exception
        ErrorResponse errorResponse = new ErrorResponse(ex.getHttpCode(), ex.getHttpStatus(), ex.getMessage());

        // Return a ResponseEntity with the HTTP status and error details
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(ex.getHttpCode()));
    }

    @Getter
    @Setter
    public static class ErrorResponse {
        private int code;         // HTTP status code
        private String status;   // HTTP status description
        private String message;  // Error message

        public ErrorResponse(int code, String status, String message) {
            this.code = code;
            this.status = status;
            this.message = message;
        }
    }
}

