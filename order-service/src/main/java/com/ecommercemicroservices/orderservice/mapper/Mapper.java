package com.ecommercemicroservices.orderservice.mapper;

import com.ecommercemicroservices.orderservice.dto.*;
import com.ecommercemicroservices.orderservice.model.Order;
import com.ecommercemicroservices.orderservice.model.OrderProduct;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static Order mapOrderRequestDTOtoOrder(OrderRequestDTO orderRequestDTO) {
        return new Order(orderRequestDTO.customerId(), mapOrderProductRequestDTOtoOrderProduct(orderRequestDTO.orderProductRequestDTOList()));
    }

    public static List<OrderProduct> mapOrderProductRequestDTOtoOrderProduct(List<OrderProductRequestDTO> orderProductRequestDTOList) {

        List<OrderProduct> orderProducts = new ArrayList<>();

        for (OrderProductRequestDTO orderProductRequestDTO : orderProductRequestDTOList) {
            OrderProduct orderProduct = new OrderProduct(orderProductRequestDTO.productId(), orderProductRequestDTO.quantity());
            orderProducts.add(orderProduct);
        }
        return orderProducts;
    }

    public static OrderResponseDTO mapOrderToOrderResponseDTO(Order order) {
        return new OrderResponseDTO(order.getId(), order.getCustomerId(), order.getOrderDate(), order.getOrderCode(),
                order.getTotalAmount(), mapOrderProductToOrderProductResponseDTO(order.getOrderProducts()));
    }

    public static List<OrderProductResponseDTO> mapOrderProductToOrderProductResponseDTO(List<OrderProduct> orderProductList) {

        List<OrderProductResponseDTO> orderProductResponseDTOList = new ArrayList<>();

        for (OrderProduct orderProduct : orderProductList) {
            OrderProductResponseDTO orderProductResponseDTO = new OrderProductResponseDTO(orderProduct.getProductId(),
                    orderProduct.getQuantity(), orderProduct.getPrice());
            orderProductResponseDTOList.add(orderProductResponseDTO);
        }
        return orderProductResponseDTOList;
    }


}
