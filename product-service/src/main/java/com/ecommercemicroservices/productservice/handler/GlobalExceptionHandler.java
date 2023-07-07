package com.ecommercemicroservices.productservice.handler;

import com.ecommercemicroservices.productservice.exception.ProductNotFoundException;
import com.ecommercemicroservices.productservice.exception.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ResponseException.class})
    public ProblemDetail handleAll(ResponseException ex) {
        return ProblemDetail.forStatusAndDetail(ex.getHttpStatus(), ex.getMessage());
    }

    @ExceptionHandler({ProductNotFoundException.class})
    public ProblemDetail handleProductNotFound(ProductNotFoundException ex) {
        return ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ProblemDetail handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST, ex.getMessage());
        problemDetail.setProperty("error", errorMap);
        return problemDetail;
    }

}