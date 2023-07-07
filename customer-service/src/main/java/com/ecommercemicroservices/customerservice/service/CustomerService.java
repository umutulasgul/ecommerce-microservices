package com.ecommercemicroservices.customerservice.service;


import com.ecommercemicroservices.customerservice.dto.CustomerRequestDTO;
import com.ecommercemicroservices.customerservice.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO);
    List<CustomerResponseDTO> getAllCustomers();
    CustomerResponseDTO getCustomerById(Integer id);
    void deleteCustomerById(Integer id);
    CustomerResponseDTO updateCustomer(Integer id, CustomerRequestDTO customerRequestDTO);
}
