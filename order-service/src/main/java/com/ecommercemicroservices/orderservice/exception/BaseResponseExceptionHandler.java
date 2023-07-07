package com.ecommercemicroservices.orderservice.exception;

import com.ecommercemicroservices.orderservice.factory.ResponseFactory;
import com.ecommercemicroservices.orderservice.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Component
public class BaseResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ResponseException.class})
    public ResponseEntity<Response> handleAll(ResponseException ex, WebRequest request) {
        return ResponseFactory.createResponse(ex.getMessage(), ex.getHttpStatus());
    }
}
