package com.example.store.dto.response;

import com.example.store.entity.Product;

import java.util.List;

public class ProductResponse extends ApiResponse{

    private List<Product> allProducts;

    public ProductResponse(int statusCode, String message, List<Product> allProducts) {
        super(statusCode, message);
        this.allProducts=allProducts;
    }
}
