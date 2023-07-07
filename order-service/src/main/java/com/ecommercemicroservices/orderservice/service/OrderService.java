package com.ecommercemicroservices.orderservice.service;

import com.ecommercemicroservices.orderservice.dto.OrderRequestDTO;
import com.ecommercemicroservices.orderservice.dto.OrderResponseDTO;

import java.util.List;

public interface OrderService {
    OrderResponseDTO placeOrder(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO getOrderById(Integer id);

    List<OrderResponseDTO> getOrdersByCustomerId(Integer customerId);

    String deleteOrderById(Integer orderId);
}
