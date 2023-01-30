package com.example.store.dto.response;

import com.example.store.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse extends ApiResponse {

    private List<Product> allProducts;
    private Product product;

    public ProductResponse(int statusCode, String message, List<Product> allProducts) {
        super(statusCode, message);
        this.allProducts = allProducts;
    }

    public ProductResponse(int statusCode, String message, Product product) {
        super(statusCode, message);
        this.product = product;
    }
}
