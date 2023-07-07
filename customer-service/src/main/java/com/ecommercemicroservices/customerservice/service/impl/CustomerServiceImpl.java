package com.ecommercemicroservices.customerservice.service.impl;

import com.ecommercemicroservices.customerservice.dto.CustomerRequestDTO;
import com.ecommercemicroservices.customerservice.dto.CustomerResponseDTO;
import com.ecommercemicroservices.customerservice.exception.CustomerNotFoundException;
import com.ecommercemicroservices.customerservice.model.Customer;
import com.ecommercemicroservices.customerservice.repository.CustomerRepository;
import com.ecommercemicroservices.customerservice.service.CustomerService;
import com.ecommercemicroservices.customerservice.mapper.Mapper;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = Mapper.mapCustomerRequestDTOtoCustomer(customerRequestDTO);
        customerRepository.save(customer);
        return Mapper.mapCustomerToCustomerResponseDTO(customer);
    }

    public List<CustomerResponseDTO> getAllCustomers() {
        List<Customer> customers = findAllCustomers();
        return customers.stream().map(Mapper::mapCustomerToCustomerResponseDTO).toList();
    }

    public CustomerResponseDTO getCustomerById(Integer id) {
        Customer customer = findCustomerById(id);
        return Mapper.mapCustomerToCustomerResponseDTO(customer);
    }

    public void deleteCustomerById(Integer id) {
        findCustomerById(id);
        customerRepository.deleteById(id);
    }

    public CustomerResponseDTO updateCustomer(Integer id, CustomerRequestDTO customerRequestDTO) {
        Customer customer = findCustomerById(id);
        Mapper.mapCustomerRequestDTOtoCustomer(customer, customerRequestDTO);
        customerRepository.save(customer);
        return Mapper.mapCustomerToCustomerResponseDTO(customer);
    }

    private Customer findCustomerById(Integer id) {
        return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }

    private List<Customer> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        if (customers.isEmpty()) {
            throw new CustomerNotFoundException();
        }
        return customers;
    }
}