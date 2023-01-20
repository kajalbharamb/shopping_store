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
    @NotNull(message = "Required")
    private Integer categoryId;
    @NotNull(message = "Required")
    private String name;
    @NotNull(message = "Required")
    private long sellingPrice;
    @NotNull(message = "Required")
    private int noInStock;
    @NotNull(message = "Required")
    private long originalPrice;
    @NotNull(message = "Required")
    private int discount;

}
