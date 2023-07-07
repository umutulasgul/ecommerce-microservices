package com.ecommercemicroservices.orderservice.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "order_product")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private BigDecimal price;

    public OrderProduct() {
    }

    public OrderProduct(String productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public OrderProduct(Order order, String productId, Integer quantity, BigDecimal price) {
        this.order = order;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderProduct(Integer id, Order order, String productId, Integer quantity, BigDecimal price) {
        this.id = id;
        this.order = order;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}