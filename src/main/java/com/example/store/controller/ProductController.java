package com.example.store.controller;
import com.example.store.dto.request.LoginDto;
import com.example.store.dto.request.ProductDto;
import com.example.store.dto.response.ProductResponse;
import com.example.store.entity.Category;
import com.example.store.dto.response.ApiResponse;
import com.example.store.repository.CategoryRepository;
import com.example.store.repository.ProductRepository;
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
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createProduct( @RequestBody ProductDto productDto){
       Optional<Category> optionalCategory= categoryRepository.findById(productDto.getCategoryId());
       if (!optionalCategory.isPresent()){
           return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST.value(), " Category does not exist"), HttpStatus.BAD_REQUEST);
       }
       productService.createProduct(productDto,optionalCategory.get());
       return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST.value(), " Product has been Added "),HttpStatus.ACCEPTED);
    }

    @PostMapping("/update/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId")Integer productId,@RequestBody ProductDto productDto) throws Exception {
        Optional<Category> optionalCategory= categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()){
            return new ResponseEntity<>(new ApiResponse(HttpStatus.BAD_REQUEST.value(), "Category does not exist"), HttpStatus.BAD_REQUEST);
        }
        Category category = optionalCategory.get();
        if (productRepository.existsById(productDto.getId())) {
            return new ResponseEntity<>(new ApiResponse(HttpStatus.CONFLICT.value(),"Product already exist"), HttpStatus.CONFLICT);
        } else
        productService.updateProduct(productDto,productId);
        return new ResponseEntity<>(new ApiResponse(HttpStatus.ACCEPTED.value(), "Product has been Updated "),HttpStatus.ACCEPTED);
    }

    @GetMapping("/list")
    public ResponseEntity<ProductResponse> getProducts() {

        return new ResponseEntity<>(new ProductResponse(HttpStatus.OK.value(), "List of products ",productService.findAllProducts()),HttpStatus.OK);
    }

    @GetMapping("/list/{categoryId}")
    public ResponseEntity<ProductResponse> getProductByCategory(@PathVariable Integer categoryId, @RequestBody LoginDto loginDto) throws Exception {
        return new ResponseEntity<>(new ProductResponse(HttpStatus.ACCEPTED.value(), "Product of particular category",productService.findAllProductCategory(categoryId, loginDto)),HttpStatus.ACCEPTED);
    }

}
