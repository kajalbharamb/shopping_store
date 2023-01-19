package com.example.store.dto;

import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class ProductDto {
    private int id;
    @NotNull
    private Integer categoryId;
    @NotNull
    private String name;
    @NotNull
    private long sellingPrice;
    @NotNull
    private int noInStock;
    @NotNull
    private long originalPrice;
    @NotNull
    private int discount;

}
