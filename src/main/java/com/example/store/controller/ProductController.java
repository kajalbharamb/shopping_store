package com.example.store.controller;
import com.example.store.dto.Login;
import com.example.store.dto.ProductDto;
import com.example.store.entity.Category;
import com.example.store.entity.Product;
import com.example.store.reponse.ApiResponse;
import com.example.store.repository.CategoryRepository;
import com.example.store.repository.ProductRepository;
import com.example.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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
    public ResponseEntity<ApiResponse> createProduct(@Valid @RequestBody ProductDto productDto){
       Optional<Category> optionalCategory= categoryRepository.findById(productDto.getCategoryId());
       if (!optionalCategory.isPresent()){
           return new ResponseEntity<>(new ApiResponse("404","Category Does not exist"), HttpStatus.BAD_REQUEST);
       }
       productService.createProduct(productDto,optionalCategory.get());
       return new ResponseEntity<>(new ApiResponse("202","product is been added"),HttpStatus.ACCEPTED);
    }

    @PostMapping("/update/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId")Integer productId,@Valid @RequestBody ProductDto productDto) throws Exception {
        Optional<Category> optionalCategory= categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()){
            return new ResponseEntity<>(new ApiResponse("404","Category Does not exist"), HttpStatus.BAD_REQUEST);
        }
        Category category = optionalCategory.get();
        if (productRepository.existsById(productDto.getId())) {
            return new ResponseEntity<>(new ApiResponse("409", "Product Already Exists"), HttpStatus.CONFLICT);
        } else
        productService.updateProduct(productDto,productId);
        return new ResponseEntity<>(new ApiResponse("202","product is been added"),HttpStatus.ACCEPTED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> getProducts(@Valid @RequestBody Login login) {

        return new ResponseEntity<>(productService.findAllProducts(login),HttpStatus.OK);
    }

    @GetMapping("/list/{categoryId}")
    public ResponseEntity<List<Product>> getProductByCategory(@PathVariable Integer categoryId,@Valid @RequestBody Login login) throws Exception {
        return new ResponseEntity<>(productService.findAllProductCategory(categoryId,login),HttpStatus.ACCEPTED);
    }

}
