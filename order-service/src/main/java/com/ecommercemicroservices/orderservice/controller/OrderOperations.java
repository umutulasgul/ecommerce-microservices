package com.ecommercemicroservices.orderservice.controller;

import com.ecommercemicroservices.orderservice.dto.OrderRequestDTO;
import com.ecommercemicroservices.orderservice.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface OrderOperations {
    @PostMapping
    ResponseEntity<Response> placeOrder(OrderRequestDTO orderRequestDTO);

    @GetMapping("/{id}")
    ResponseEntity<Response> getById(@PathVariable Integer id);

    @DeleteMapping("/{id}")
    ResponseEntity<Response> deleteById(@PathVariable Integer id);

    @GetMapping
    ResponseEntity<Response> getByCustomerId(Integer id);
}
