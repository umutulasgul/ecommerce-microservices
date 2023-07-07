package com.ecommercemicroservices.productservice.exception;

import com.ecommercemicroservices.productservice.constant.MessageConstant;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super(MessageConstant.PRODUCT_NOT_FOUND);
    }
}

