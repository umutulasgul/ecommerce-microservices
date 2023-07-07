package com.ecommercemicroservices.customerservice.controller;

import com.ecommercemicroservices.customerservice.dto.CustomerRequestDTO;
import com.ecommercemicroservices.customerservice.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CustomerOperations {

    @PostMapping
    ResponseEntity<Response> create(CustomerRequestDTO customerRequestDTO);

    @GetMapping
    ResponseEntity<Response> getAll();

    @GetMapping("/{id}")
    ResponseEntity<Response> getById(@PathVariable Integer id);

    @PutMapping("/{id}")
    ResponseEntity<Response> updateById(@PathVariable Integer id, @RequestBody CustomerRequestDTO customerRequestDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Response> deleteById(@PathVariable Integer id);
}
