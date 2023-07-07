package com.ecommercemicroservices.orderservice.dto;

import java.math.BigDecimal;

public record OrderProductResponseDTO(String productId, Integer quantity, BigDecimal price) {
}
