package com.ecommercemicroservices.orderservice.dto;


import java.util.List;

public record OrderRequestDTO(Integer customerId, List<OrderProductRequestDTO> orderProductRequestDTOList) {
}
