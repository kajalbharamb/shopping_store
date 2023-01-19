package com.example.store.service;

import com.example.store.dto.OrderDto;
import com.example.store.dto.ProductDto;
import com.example.store.entity.Product;
import com.example.store.entity.Sales;
import com.example.store.repository.OrderRepository;
import com.example.store.repository.ProductRepository;
import com.example.store.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SalesRepository salesRepository;
   

    public Product postorder(OrderDto orderDto) {
        Optional<Product> optionalProduct=productRepository.findById(orderDto.getProductId());
        Product product=optionalProduct.get();
        product.setName(product.getName());
        product.setNoInStock(product.getNoInStock()-orderDto.getQuantity());
        product.setOriginalPrice(product.getOriginalPrice());
        product.setDiscount(product.getDiscount());
        product.setSellingprice(product.getSellingprice());
        productRepository.save(product);
        Sales sales = null;
        sales.setProductId(orderDto.getProductId());
        sales.setUserId(orderDto.getUserId());
        sales.setSoldStock(orderDto.getQuantity());
        salesRepository.save(sales);
        return product;
    }
       }

