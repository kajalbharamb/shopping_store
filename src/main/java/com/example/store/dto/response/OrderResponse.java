package com.example.store.dto.response;

import com.example.store.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse extends ApiResponse {
    private String message;
    int status;
    private Product product;

    public OrderResponse(int status, String message, Product product) {
        this.status=status;
        this.message=message;
        this.product = product;
    }

//    public OrderResponse(int statusCode, String message, Product product) {
//        super(statusCode,message);
//        this.product = product;
//    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
