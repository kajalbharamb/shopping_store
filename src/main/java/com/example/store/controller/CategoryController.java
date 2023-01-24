package com.example.store.controller;
import com.example.store.dto.request.LoginDto;
import com.example.store.dto.request.CategoryDto;
import com.example.store.dto.response.CategoryResponse;
import com.example.store.dto.response.ApiResponse;
import com.example.store.repository.CategoryRepository;
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
    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody CategoryDto categoryDto){
        categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(new ApiResponse(202, "created a new category"), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<CategoryResponse> displayCategory(LoginDto loginDto){
        return new ResponseEntity<>(new CategoryResponse(HttpStatus.ACCEPTED.value(),"Category list",categoryService.findCategory(loginDto)), HttpStatus.ACCEPTED);
    }
}
