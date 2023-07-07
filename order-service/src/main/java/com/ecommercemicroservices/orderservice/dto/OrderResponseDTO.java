package com.ecommercemicroservices.orderservice.dto;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public record OrderResponseDTO(Integer orderId, Integer customerId, Date orderDate, String orderCode,
                               BigDecimal totalAmount, List<OrderProductResponseDTO> orderProductResponseDTOList) {
}
