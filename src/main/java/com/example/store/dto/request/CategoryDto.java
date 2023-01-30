package com.example.store.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDto {

    @NotEmpty(message = "Category name is mandatory")
    private String categoryName;

}
