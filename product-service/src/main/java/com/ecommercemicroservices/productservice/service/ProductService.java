package com.ecommercemicroservices.productservice.service;

import com.ecommercemicroservices.productservice.dto.ProductRequestDTO;
import com.ecommercemicroservices.productservice.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);

    ProductResponseDTO getProductById(String id);

    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO updateProduct(String id, ProductRequestDTO productRequestDTO);

    void deleteProductById(String id);

}
