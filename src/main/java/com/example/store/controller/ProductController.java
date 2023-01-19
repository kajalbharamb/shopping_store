package com.example.store.controller;

import com.example.store.dto.Login;
import com.example.store.dto.ProductDto;
import com.example.store.entity.Category;
import com.example.store.entity.Product;
import com.example.store.reponse.ApiResponse;
import com.example.store.repository.CategoryRepository;
import com.example.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto){
       Optional<Category> optionalCategory= categoryRepository.findById(productDto.getCategoryId());
       if (!optionalCategory.isPresent()){
           return new ResponseEntity<>(new ApiResponse("404","Category Does not exist"), HttpStatus.BAD_REQUEST);
       }
       productService.createProduct(productDto,optionalCategory.get());
       return new ResponseEntity<>(new ApiResponse("202","product is been added"),HttpStatus.ACCEPTED);
    }

    @PostMapping("/update/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId")Integer productId,@RequestBody ProductDto productDto) throws Exception {
        Optional<Category> optionalCategory= categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()){
            return new ResponseEntity<>(new ApiResponse("404","Category Does not exist"), HttpStatus.BAD_REQUEST);
        }
        productService.updateProduct(productDto,productId);
        return new ResponseEntity<>(new ApiResponse("202","product is been added"),HttpStatus.ACCEPTED);
    }

    @GetMapping("/list")
    public List<Product> getProducts(Login login) {
     return productService.findAllProducts(login);
    }

    @GetMapping("/list/{categoryId}")
    public List<Product> getProductByCategory(@PathVariable Integer categoryId,Login login) throws Exception {
        return productService.findAllProductCategory(categoryId,login);
    }

}
