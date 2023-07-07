package com.ecommercemicroservices.productservice.controller;

import com.ecommercemicroservices.productservice.dto.ProductRequestDTO;
import com.ecommercemicroservices.productservice.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ProductOperations {

    @PostMapping
    ResponseEntity<Response> create(ProductRequestDTO productRequestDTO);

    @GetMapping
    ResponseEntity<Response> getAll();

    @GetMapping("/{id}")
    ResponseEntity<Response> getById(@PathVariable String id);

    @PutMapping("/{id}")
    ResponseEntity<Response> updateById(@PathVariable String id, @RequestBody ProductRequestDTO productRequestDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<Response> deleteById(@PathVariable String id);
}
