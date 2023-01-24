package com.example.store.dto.request;
import lombok.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class ProductDto {

    private int id;
    @NotNull(message = "Required categoryId")
    private Integer categoryId;
    @NotNull(message = "Required Product Name")
    private String name;
    @NotNull(message = "Required Selling Price")
    private long sellingPrice;
    @NotNull(message = "Required NoInStock")
    private int noInStock;
    @NotNull(message = "Required Original Price")
    private long originalPrice;
    @NotNull(message = "Required Discount")
    private int discount;

}
