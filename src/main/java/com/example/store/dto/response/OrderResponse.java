package com.example.store.dto.response;

import com.example.store.entity.Product;

public class OrderResponse extends ApiResponse {
    private Product product;

    public OrderResponse(int statusCode, String message, Product product) {
        super(statusCode,message);
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
