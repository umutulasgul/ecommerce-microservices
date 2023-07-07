package com.ecommercemicroservices.orderservice.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "order_code", unique = true)
    private String orderCode;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderProduct> orderProducts;

    public Order() {
    }

    public Order(Integer customerId, List<OrderProduct> orderProducts) {
        this.customerId = customerId;
        this.orderProducts = orderProducts;
    }

    public Order(Integer customerId, String orderCode, Date orderDate, BigDecimal totalAmount, List<OrderProduct> orderProducts) {
        this.customerId = customerId;
        this.orderCode = orderCode;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.orderProducts = orderProducts;
    }

    public Order(Integer id, Integer customerId, String orderCode, Date orderDate, BigDecimal totalAmount, List<OrderProduct> orderProducts) {
        this.id = id;
        this.customerId = customerId;
        this.orderCode = orderCode;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.orderProducts = orderProducts;
    }

    public Integer getId() {
        return id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }
}