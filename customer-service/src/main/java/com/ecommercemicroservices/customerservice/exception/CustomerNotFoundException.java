package com.ecommercemicroservices.customerservice.exception;

import com.ecommercemicroservices.customerservice.constant.MessageConstant;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException() {
        super(MessageConstant.CUSTOMER_NOT_FOUND);
    }
}

