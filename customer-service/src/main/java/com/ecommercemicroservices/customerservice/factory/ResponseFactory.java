package com.ecommercemicroservices.customerservice.factory;


import com.ecommercemicroservices.customerservice.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class ResponseFactory {

    public static ResponseEntity<Response> createResponse(String message, HttpStatus httpStatus) {
        return new ResponseEntity<>(new Response(message), httpStatus);
    }

    public static ResponseEntity<Response> createResponse(String message, Object data, HttpStatus httpStatus) {
        return new ResponseEntity<>(new Response(message, data), httpStatus);
    }

    public static ResponseEntity<Response> createResponse(Object data, HttpStatus httpStatus) {
        return new ResponseEntity<>(new Response(data), httpStatus);
    }

    public static ResponseEntity<Response> createResponse(Map<String, String> data, HttpStatus httpStatus) {
        return new ResponseEntity<>(new Response(data), httpStatus);
    }
}
