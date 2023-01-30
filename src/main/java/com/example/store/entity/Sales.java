package com.example.store.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int salesId;
    @NotNull(message = "Required ProductId")
    private int productId;
    @NotEmpty(message = "Product name required")
    private String productName;
    @NotNull(message = "Required Product Selling Price")
    private int productSellingPrice;
    @NotEmpty(message = "Required UserId")
    private String userId;
    @NotNull(message = "Required SoldStock")
    private int soldStock;
}
