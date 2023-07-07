package com.ecommercemicroservices.productservice.exception;

import org.springframework.http.HttpStatus;

public class ResponseException extends RuntimeException {

    private String message;
    private HttpStatus httpStatus;

    public ResponseException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public ResponseException() {
    }


    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
