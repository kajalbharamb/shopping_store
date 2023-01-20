package com.example.store.service;

import com.example.store.dto.Login;
import com.example.store.dto.OrderDto;
import com.example.store.entity.ActivityHistory;
import com.example.store.entity.Product;
import com.example.store.entity.Sales;
import com.example.store.repository.AcitvityHistoryRepository;
import com.example.store.repository.OrderRepository;
import com.example.store.repository.ProductRepository;
import com.example.store.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private AcitvityHistoryRepository acitvityHistoryRepository;
   

    public String postorder(OrderDto orderDto, Login login) {
        Optional<Product> optionalProduct=productRepository.findById(orderDto.getProductId());
        Product product=optionalProduct.get();
        int leftStock = product.getNoInStock() - orderDto.getQuantity();
        if(leftStock>0){
        product.setName(product.getName());
        product.setNoInStock(leftStock);
        product.setOriginalPrice(product.getOriginalPrice());
        product.setDiscount(product.getDiscount());
        product.setSellingPrice(product.getSellingPrice());
        productRepository.save(product);
        Sales sales=new Sales();
        sales.setProductId(orderDto.getProductId());
        sales.setUserId(orderDto.getUserId());
        sales.setSoldStock(orderDto.getQuantity());
        sales.setProductName(product.getName());
        sales.setProductSellingPrice((int) product.getSellingPrice());
        salesRepository.save(sales);
        acitvityHistoryRepository.save(new ActivityHistory(login.getEmail(),"user has order the product"+product.getName()));
        return "Order Placed";
        }
        else{
            return "Stock not available";
        }
    }
       }

