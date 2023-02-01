package com.example.store.controller;

import com.example.store.dto.request.LoginDto;
import com.example.store.dto.response.ApiResponse;
import com.example.store.dto.response.CategoryResponse;
import com.example.store.entity.Category;
import com.example.store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody Category category) {

        return new ResponseEntity<>(new CategoryResponse(HttpStatus.CREATED.value(), "Created a new category",  categoryService.createCategory(category)), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<CategoryResponse> displayCategory(LoginDto loginDto) {
        return new ResponseEntity<>(new CategoryResponse(HttpStatus.ACCEPTED.value(), "Category list", categoryService.findCategory(loginDto)), HttpStatus.ACCEPTED);
    }
}
