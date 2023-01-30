package com.example.store.controller;

import com.example.store.dto.request.LoginDto;
import com.example.store.dto.request.ProductDto;
import com.example.store.dto.response.ProductResponse;
import com.example.store.entity.Category;
import com.example.store.repository.ProductRepository;
import com.example.store.service.CategoryService;
import com.example.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/add")
    public ResponseEntity<ProductResponse> createPoduct(@RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = categoryService.findByCategoryId(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<>(new ProductResponse(HttpStatus.BAD_REQUEST.value(), " Category does not exist", productService.createProduct(productDto, optionalCategory.get())), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ProductResponse(HttpStatus.BAD_REQUEST.value(), " Product has been Added ", productService.createProduct(productDto, optionalCategory.get())), HttpStatus.ACCEPTED);
    }

    @PostMapping("/update/{productId}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable("productId") Integer productId, @RequestBody ProductDto productDto) throws Exception {
        Optional<Category> optionalCategory = categoryService.findByCategoryId(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<>(new ProductResponse(HttpStatus.BAD_REQUEST.value(), "Category does not exist", productService.updateProduct(productDto, productId)), HttpStatus.BAD_REQUEST);
        }
        Category category = optionalCategory.get();
        if (productService.existByGetId(productDto.getId())) {
            return new ResponseEntity<>(new ProductResponse(HttpStatus.CONFLICT.value(), "Product already exist", productService.updateProduct(productDto, productId)), HttpStatus.CONFLICT);
        } else
            return new ResponseEntity<>(new ProductResponse(HttpStatus.ACCEPTED.value(), "Product has been Updated ", productService.updateProduct(productDto, productId)), HttpStatus.ACCEPTED);
    }

    @GetMapping("/list")
    public ResponseEntity<ProductResponse> getProducts() {

        return new ResponseEntity<>(new ProductResponse(HttpStatus.OK.value(), "List of products ", productService.findAllProducts()), HttpStatus.OK);
    }

    @GetMapping("/listByCategory/{categoryId}")
    public ResponseEntity<ProductResponse> getProductByCategory(@PathVariable Integer categoryId, @RequestBody LoginDto loginDto) throws Exception {
        return new ResponseEntity<>(new ProductResponse(HttpStatus.ACCEPTED.value(), "Product of particular category", productService.findAllProductCategory(categoryId, loginDto)), HttpStatus.ACCEPTED);
    }

}
