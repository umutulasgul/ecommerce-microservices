package com.ecommercemicroservices.customerservice.mapper;


import com.ecommercemicroservices.customerservice.dto.CustomerRequestDTO;
import com.ecommercemicroservices.customerservice.dto.CustomerResponseDTO;
import com.ecommercemicroservices.customerservice.model.Customer;

public class Mapper {
    public static Customer mapCustomerRequestDTOtoCustomer(CustomerRequestDTO customerRequestDTO) {
        return new Customer(customerRequestDTO.name(), customerRequestDTO.surname(), customerRequestDTO.email(),
                customerRequestDTO.phone(), customerRequestDTO.address());

    }

    public static CustomerResponseDTO mapCustomerToCustomerResponseDTO(Customer customer) {
        return new CustomerResponseDTO(customer.getCustomerId(), customer.getName(), customer.getSurname(),
                customer.getAddress(), customer.getPhone(), customer.getEmail());
    }

    public static void mapCustomerRequestDTOtoCustomer(Customer customer, CustomerRequestDTO customerRequestDTO) {
        customer.setName(customerRequestDTO.name());
        customer.setSurname(customerRequestDTO.surname());
        customer.setEmail(customerRequestDTO.email());
        customer.setPhone(customerRequestDTO.phone());
        customer.setAddress(customerRequestDTO.address());
    }
}