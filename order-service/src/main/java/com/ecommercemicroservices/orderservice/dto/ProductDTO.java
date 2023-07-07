package com.ecommercemicroservices.orderservice.dto;

import java.math.BigDecimal;


public class ProductDTO {
    private String productId;
    private BigDecimal price;
    private Integer stock;

    public ProductDTO() {
    }

    public ProductDTO(String productId, BigDecimal price, Integer stock) {
        this.productId = productId;
        this.price = price;
        this.stock = stock;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
