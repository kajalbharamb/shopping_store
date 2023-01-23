package com.example.store.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
