package com.ecommercemicroservices.orderservice.controller;

import com.ecommercemicroservices.orderservice.constant.MessageConstant;
import com.ecommercemicroservices.orderservice.dto.OrderRequestDTO;
import com.ecommercemicroservices.orderservice.factory.ResponseFactory;
import com.ecommercemicroservices.orderservice.model.Response;
import com.ecommercemicroservices.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/orders")
public class OrderController implements OrderOperations{

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public ResponseEntity<Response> placeOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        return ResponseFactory.createResponse(MessageConstant.ORDER_CREATED,orderService.placeOrder(orderRequestDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Response> getById(@PathVariable("id") Integer id) {
        return ResponseFactory.createResponse(orderService.getOrderById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> getByCustomerId(@RequestParam Integer customerId) {
        return ResponseFactory.createResponse(orderService.getOrdersByCustomerId(customerId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> deleteById(@PathVariable("id") Integer id) {
        return ResponseFactory.createResponse(orderService.deleteOrderById(id), HttpStatus.OK);
    }
}
