package com.example.store.dto.response;

import com.example.store.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse extends ApiResponse {
    private Category category;
    private List<Category> categoryList;


    public CategoryResponse(int statusCode, String message, List<Category> categoryList) {
        super(statusCode, message);
        this.categoryList = categoryList;
    }

    public CategoryResponse(int statusCode, String message, Category category) {
        super(statusCode, message);
        this.category = category;
    }
}
