package com.ecommercemicroservices.productservice.service.impl;

import com.ecommercemicroservices.productservice.dto.ProductRequestDTO;
import com.ecommercemicroservices.productservice.dto.ProductResponseDTO;
import com.ecommercemicroservices.productservice.exception.ProductNotFoundException;
import com.ecommercemicroservices.productservice.model.Product;
import com.ecommercemicroservices.productservice.repository.ProductRepository;
import com.ecommercemicroservices.productservice.mapper.Mapper;
import com.ecommercemicroservices.productservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product product = Mapper.mapProductRequestDTOtoProduct(productRequestDTO);
        product.setProductCode(generateProductCode());
        productRepository.save(product);
        return Mapper.mapProductToProductResponseDTO(product);
    }

    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty())
            throw new ProductNotFoundException();
        return products.stream().map(Mapper::mapProductToProductResponseDTO).toList();
    }

    public ProductResponseDTO getProductById(String id) {
        return Mapper.mapProductToProductResponseDTO(findProductById(id));
    }

    public void deleteProductById(String id) {
        findProductById(id);
        productRepository.deleteById(id);
    }

    public ProductResponseDTO updateProduct(String id, ProductRequestDTO productRequestDTO) {
        Product product = findProductById(id);
        Mapper.mapProductRequestDTOtoProduct(product, productRequestDTO);
        productRepository.save(product);
        return Mapper.mapProductToProductResponseDTO(product);
    }

    private String generateProductCode() {
        SecureRandom random = new SecureRandom();
        String str = new BigInteger(130, random).toString(10);
        return (str.substring(0, 12));
    }

    private Product findProductById(String id) {
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }
}
