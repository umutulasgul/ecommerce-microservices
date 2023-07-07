package com.ecommercemicroservices.customerservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerRequestDTO(
        @NotBlank(message = "Customer name can not be empty!") String name,
        @NotBlank(message = "Customer surname can not be empty!") String surname,
        @NotBlank(message = "Customer address can not be empty!") String address,
        @NotBlank(message = "Customer phone can not be empty!") String phone,
        @NotBlank @Email(message = "Customer email can not be empty!") String email) {
}
