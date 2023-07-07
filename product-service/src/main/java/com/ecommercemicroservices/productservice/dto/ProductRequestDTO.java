package com.ecommercemicroservices.productservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequestDTO(
        @NotBlank(message = "Product name can not be empty!") String name,
        @NotBlank(message = "Product description can not be empty!") String description,
        @NotNull(message = "Product price can not be null!") BigDecimal price,
        @NotNull(message = "Product stock can not be null!") Integer stock) {
}
