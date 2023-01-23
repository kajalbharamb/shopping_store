package com.example.store.reponse;

import com.example.store.entity.Product;

public class ProductResponse extends ApiResponse{
    private Product product;

    public ProductResponse(int statusCode, String message, Product product) {
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
