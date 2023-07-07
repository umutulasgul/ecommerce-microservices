package com.ecommercemicroservices.customerservice.handler;

import com.ecommercemicroservices.customerservice.exception.CustomerNotFoundException;
import com.ecommercemicroservices.customerservice.exception.ResponseException;
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

    @ExceptionHandler({CustomerNotFoundException.class})
    public ProblemDetail handleCustomerNotFound(CustomerNotFoundException ex) {
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