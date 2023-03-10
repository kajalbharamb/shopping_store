package com.example.store.service;

import com.example.store.dto.request.LoginDto;
import com.example.store.dto.request.ProductDto;
import com.example.store.entity.ActivityHistory;
import com.example.store.entity.Category;
import com.example.store.entity.Product;
import com.example.store.repository.AcitvityHistoryRepository;
import com.example.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    public AcitvityHistoryRepository acitvityHistoryRepository;
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setNoInStock(productDto.getNoInStock());
        product.setOriginalPrice(productDto.getOriginalPrice());
        product.setDiscount(productDto.getDiscount());
        product.setSellingPrice(productDto.getSellingPrice());
        product.setCategory(category);
        productRepository.save(product);
        return product;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(ProductDto productDto, Integer productId) throws Exception {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent()) {
            throw new Exception("product not found");
        }
        Product product = optionalProduct.get();
        product.setName(productDto.getName());
        product.setNoInStock(productDto.getNoInStock());
        product.setOriginalPrice(productDto.getOriginalPrice());
        product.setDiscount(productDto.getDiscount());
        product.setSellingPrice(productDto.getSellingPrice());
        productRepository.save(product);
        return product;
    }

    public boolean existByGetId(int id) {
        return productRepository.existsById(id);
    }

}
