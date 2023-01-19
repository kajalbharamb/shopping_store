package com.example.store.service;

import com.example.store.dto.ProductDto;
import com.example.store.entity.Category;
import com.example.store.entity.Product;
import com.example.store.repository.CategoryRepository;
import com.example.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public void createProduct(ProductDto productDto, Category category) {
        Product product=new Product();
        product.setName(productDto.getName());
        product.setNoInStock(productDto.getNoInStock());
        product.setOriginalPrice(productDto.getOriginalPrice());
        product.setDiscount(productDto.getDiscount());
        product.setSellingprice(productDto.getSellingprice());
        product.setCategory(category);
        productRepository.save(product);
    }

    public ProductDto getProductDto(Product product){
        ProductDto productDto=new ProductDto();
        productDto.setName(product.getName());
        productDto.setNoInStock(product.getNoInStock());
        productDto.setOriginalPrice(product.getOriginalPrice());
        productDto.setDiscount(product.getDiscount());
        productDto.setSellingprice(product.getSellingprice());
        productDto.setCategoryId(product.getCategory().getId());
        return productDto;
    }

    public List<Product> findAllProducts(){
      return productRepository.findAll();
    }

    public void updateProduct(ProductDto productDto, Integer productId) throws Exception{
        Optional<Product> optionalProduct=productRepository.findById(productId);
        if (!optionalProduct.isPresent()){
            throw new Exception("product not found");
        }
            Product product=optionalProduct.get();
            product.setName(productDto.getName());
            product.setNoInStock(productDto.getNoInStock());
            product.setOriginalPrice(productDto.getOriginalPrice());
            product.setDiscount(productDto.getDiscount());
            product.setSellingprice(productDto.getSellingprice());
            productRepository.save(product);
    }


    public List<Product> findAllProductCategory(Integer categoryId) {
        return productRepository.findProductByCategory(categoryId);
    }

}
