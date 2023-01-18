package com.example.store.dto;

public class OrderDto
{
    private int productId;
    private String UserId;
    private int quantity;

    public OrderDto(int productId, String userId, int quantity) {
        this.productId = productId;
        UserId = userId;
        this.quantity = quantity;
    }

    public OrderDto() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}
