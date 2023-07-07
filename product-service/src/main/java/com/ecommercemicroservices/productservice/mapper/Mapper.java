package com.ecommercemicroservices.productservice.mapper;

import com.ecommercemicroservices.productservice.dto.ProductRequestDTO;
import com.ecommercemicroservices.productservice.dto.ProductResponseDTO;
import com.ecommercemicroservices.productservice.model.Product;

public class Mapper {
    public static Product mapProductRequestDTOtoProduct(ProductRequestDTO productRequestDTO) {
        return new Product(productRequestDTO.name(), productRequestDTO.description(), productRequestDTO.price(), productRequestDTO.stock());
    }

    public static ProductResponseDTO mapProductToProductResponseDTO(Product product) {
        return new ProductResponseDTO(product.getId(), product.getName(), product.getDescription(), product.getProductCode(), product.getPrice(), product.getStock());
    }

    public static void mapProductRequestDTOtoProduct(Product product, ProductRequestDTO productRequestDTO) {
        product.setName(productRequestDTO.name());
        product.setDescription(productRequestDTO.description());
        product.setPrice(productRequestDTO.price());
        product.setStock(productRequestDTO.stock());
    }
}
