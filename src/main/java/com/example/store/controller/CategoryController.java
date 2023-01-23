package com.example.store.controller;

import com.example.store.dto.Login;
import com.example.store.entity.Category;
import com.example.store.reponse.ApiResponse;
import com.example.store.repository.CategoryRepository;
import com.example.store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponse(202, "created a new category"), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Category>> displayCategory(Login login){
        return new ResponseEntity<>(categoryService.findCategory(login), HttpStatus.ACCEPTED);
    }
}
