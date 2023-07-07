package com.ecommercemicroservices.productservice.repository;

import com.ecommercemicroservices.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository<Product, String> {
}
