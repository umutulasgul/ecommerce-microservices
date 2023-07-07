package com.ecommercemicroservices.orderservice.client;

import com.ecommercemicroservices.orderservice.dto.ProductDTO;
import com.ecommercemicroservices.orderservice.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "api-gateway")
public interface ProductServiceClient {
    @GetMapping("/v1/products/{id}")
    ResponseEntity<Response> getProductById(@PathVariable String id);

    @PutMapping("/v1/products/{id}")
    void updateById(@PathVariable String id, @RequestBody ProductDTO productDTO);
}
