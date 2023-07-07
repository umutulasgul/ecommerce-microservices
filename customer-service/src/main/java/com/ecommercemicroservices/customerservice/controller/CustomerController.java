package com.ecommercemicroservices.customerservice.controller;

import com.ecommercemicroservices.customerservice.constant.MessageConstant;
import com.ecommercemicroservices.customerservice.dto.CustomerRequestDTO;
import com.ecommercemicroservices.customerservice.factory.ResponseFactory;
import com.ecommercemicroservices.customerservice.model.Response;
import com.ecommercemicroservices.customerservice.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController implements CustomerOperations {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public ResponseEntity<Response> create(@RequestBody @Valid CustomerRequestDTO customerRequestDTO) {
        return ResponseFactory.createResponse(MessageConstant.CUSTOMER_CREATED, customerService.createCustomer(customerRequestDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Response> getAll() {
        return ResponseFactory.createResponse(MessageConstant.SUCCESS, customerService.getAllCustomers(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> getById(@PathVariable("id") Integer id) {
        return ResponseFactory.createResponse(MessageConstant.SUCCESS, customerService.getCustomerById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> updateById(@PathVariable("id") Integer id, @RequestBody @Valid CustomerRequestDTO customerRequestDTO) {
        return ResponseFactory.createResponse(MessageConstant.CUSTOMER_UPDATED, customerService.updateCustomer(id, customerRequestDTO), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Response> deleteById(@PathVariable("id") Integer id) {
        customerService.deleteCustomerById(id);
        return ResponseFactory.createResponse(MessageConstant.CUSTOMER_DELETED, HttpStatus.OK);
    }
}
