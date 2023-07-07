package com.ecommercemicroservices.customerservice.dto;

public record CustomerResponseDTO(Integer id,String name, String surname, String address, String phone, String email) {
}
