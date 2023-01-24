package com.example.store.dto.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class CategoryDto {

    @NotEmpty(message = "Category name is mandatory")
    private String categoryName;

}
