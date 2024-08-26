package org.majestic.majesticMusic.exception;

public class BusinessException extends RuntimeException {

    private final int httpCode;       // HTTP status code (400, 404 etc.)
    private final String httpStatus;  // HTTP status description (Bad Request, Not Found etc.)

    // Constructor with HTTP code, status, and message
    public BusinessException(int httpCode, String httpStatus, String message) {
        super(message);
        this.httpCode = httpCode;
        this.httpStatus = httpStatus;
    }

    // Constructor with HTTP code, status, message, and cause
    public BusinessException(int httpCode, String httpStatus, String message, Throwable cause) {
        super(message, cause);
        this.httpCode = httpCode;
        this.httpStatus = httpStatus;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public String getHttpStatus() {
        return httpStatus;
    }
}
