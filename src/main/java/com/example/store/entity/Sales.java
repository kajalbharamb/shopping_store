package com.example.store.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salesId;
    @NotNull(message = "Required")
    private int productId;
    @NotEmpty(message = "Product name required")
    private String productName;
    @NotNull(message = "Required")
    private int productSellingPrice;
    @NotEmpty(message = "Required")
    private String userId;
    @NotNull(message = "Required")
    private int soldStock;



}
