package com.ecommercemicroservices.orderservice.service.impl;

import com.ecommercemicroservices.orderservice.client.ProductServiceClient;
import com.ecommercemicroservices.orderservice.constant.MessageConstant;
import com.ecommercemicroservices.orderservice.dto.*;
import com.ecommercemicroservices.orderservice.exception.ResponseException;
import com.ecommercemicroservices.orderservice.model.Order;
import com.ecommercemicroservices.orderservice.model.OrderProduct;
import com.ecommercemicroservices.orderservice.model.Response;
import com.ecommercemicroservices.orderservice.repository.OrderRepository;
import com.ecommercemicroservices.orderservice.service.OrderService;
import com.ecommercemicroservices.orderservice.util.JsonUtil;
import com.ecommercemicroservices.orderservice.mapper.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;
    private final ProductServiceClient productServiceClient;

    public OrderServiceImpl(OrderRepository orderRepository, ProductServiceClient productServiceClient) {
        this.orderRepository = orderRepository;
        this.productServiceClient = productServiceClient;
    }

    @Override
    public OrderResponseDTO placeOrder(OrderRequestDTO orderRequestDTO) {

        BigDecimal totalAmount = BigDecimal.valueOf(0);

        Order order = Mapper.mapOrderRequestDTOtoOrder(orderRequestDTO);
        List<OrderProduct> orderProducts = order.getOrderProducts();

        for (OrderProduct orderProduct : orderProducts) {
            ProductDTO product = getProductByIdFromProductService(orderProduct.getProductId());
            orderProduct.setPrice(product.getPrice());
            BigDecimal amount = product.getPrice().multiply(BigDecimal.valueOf(orderProduct.getQuantity()));
            totalAmount = totalAmount.add(amount);
            orderProduct.setOrder(order);
            updateStock(product ,orderProduct );
        }
        order.setOrderDate(new Date());
        order.setOrderCode(generateOrderCode());
        order.setTotalAmount(totalAmount);
        orderRepository.save(order);
        return Mapper.mapOrderToOrderResponseDTO(order);
    }

    @Override
    public OrderResponseDTO getOrderById(Integer id) {
        Order order = findOrderById(id);
        return Mapper.mapOrderToOrderResponseDTO(order);
    }

    @Override
    public List<OrderResponseDTO> getOrdersByCustomerId(Integer customerId) {
        List<Order> orders = orderRepository.findAllByCustomerId(customerId);
        if (orders.isEmpty())
            throw new ResponseException(MessageConstant.ORDER_NOT_FOUND, HttpStatus.NOT_FOUND);
        return orders.stream().map(Mapper::mapOrderToOrderResponseDTO).toList();
    }

    @Override
    public String deleteOrderById(Integer orderId) {
        Order order = findOrderById(orderId);
        orderRepository.delete(order);
        return MessageConstant.ORDER_DELETED;
    }

    private String generateOrderCode() {
        SecureRandom random = new SecureRandom();
        String str = new BigInteger(130, random).toString(10);
        return ("ORD" + str.substring(0, 8));
    }

    private Order findOrderById(Integer id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isEmpty())
            throw new ResponseException(MessageConstant.ORDER_NOT_FOUND, HttpStatus.NOT_FOUND);

        else
            return orderOptional.get();

    }

    private ProductDTO getProductByIdFromProductService(String id) {
        ResponseEntity<Response> responseProduct = productServiceClient.getProductById(id);
        return JsonUtil.convertValue(Objects.requireNonNull(responseProduct.getBody()).getData(), ProductDTO.class);
    }

    private void updateStock(ProductDTO product, OrderProduct orderProduct) {
        product.setStock(product.getStock() - orderProduct.getQuantity());
        productServiceClient.updateById(orderProduct.getProductId(), product);
    }
}
