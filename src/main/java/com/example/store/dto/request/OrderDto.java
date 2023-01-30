package com.example.store.dto.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class OrderDto {
    @NotNull(message = "Required ProductId")
    private int productId;
    @NotEmpty(message = "Required UserId")
    private String userId;
    @NotNull(message = "Required Quantity")
    private int quantity;

}