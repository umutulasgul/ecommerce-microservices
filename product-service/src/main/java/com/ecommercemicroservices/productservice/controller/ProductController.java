package com.ecommercemicroservices.productservice.controller;

import com.ecommercemicroservices.productservice.constant.MessageConstant;
import com.ecommercemicroservices.productservice.dto.ProductRequestDTO;
import com.ecommercemicroservices.productservice.factory.ResponseFactory;
import com.ecommercemicroservices.productservice.model.Response;
import com.ecommercemicroservices.productservice.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/products")
public class ProductController implements ProductOperations {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<Response> create(@RequestBody @Valid ProductRequestDTO productRequestDTO) {
        return ResponseFactory.createResponse(MessageConstant.PRODUCT_CREATED, productService.createProduct(productRequestDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Response> getAll() {
        return ResponseFactory.createResponse(MessageConstant.SUCCESS, productService.getAllProducts(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> getById(@PathVariable("id") String id) {
        return ResponseFactory.createResponse(MessageConstant.SUCCESS, productService.getProductById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> updateById(@PathVariable("id") String id, @RequestBody ProductRequestDTO productRequestDTO) {
        return ResponseFactory.createResponse(MessageConstant.PRODUCT_UPDATED, productService.updateProduct(id, productRequestDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> deleteById(@PathVariable("id") String id) {
        productService.deleteProductById(id);
        return ResponseFactory.createResponse(MessageConstant.PRODUCT_DELETED, HttpStatus.OK);
    }
}


