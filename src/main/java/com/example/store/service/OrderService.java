package com.example.store.service;

import com.example.store.dto.request.OrderDto;
import com.example.store.entity.ActivityHistory;
import com.example.store.entity.Product;
import com.example.store.entity.Sales;
import com.example.store.repository.AcitvityHistoryRepository;
import com.example.store.repository.OrderRepository;
import com.example.store.repository.ProductRepository;
import com.example.store.repository.SalesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@Slf4j
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private AcitvityHistoryRepository acitvityHistoryRepository;

    public Product postorder(OrderDto orderDto) throws ResponseStatusException {
        Optional<Product> optionalProduct = productRepository.findById(orderDto.getProductId());
        if (!optionalProduct.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot order!");
        }
        Product product = optionalProduct.get();
        int currentStock = product.getNoInStock() - orderDto.getQuantity();
        if (currentStock >= 0) {
            Product product1 = updateStock(product, currentStock);
            sales(product1,orderDto);
            acitvityHistoryRepository.save(new ActivityHistory(orderDto.getUserId(), "User has order the product" + product.getName()));
            return product;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot order! stock not available");
        }
    }

    public Product updateStock(Product product, int currentStock) {
        product.setNoInStock(currentStock);
        return productRepository.save(product);
    }

    public void sales(Product product1,OrderDto orderDto){
        Sales sales = Sales.builder()
                .productName(product1.getName())
                .userId(orderDto.getUserId())
                .productSellingPrice((int) product1.getSellingPrice())
                .productId(product1.getId())
                .soldStock(product1.getNoInStock()).
                build();
        salesRepository.save(sales);
    }
}

