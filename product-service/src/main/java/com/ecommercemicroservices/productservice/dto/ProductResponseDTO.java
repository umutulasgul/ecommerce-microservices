package com.ecommercemicroservices.productservice.dto;

import java.math.BigDecimal;

public record ProductResponseDTO(String id, String name, String description, String productCode, BigDecimal price,
                                 Integer stock) {
}
