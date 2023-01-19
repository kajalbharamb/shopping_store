package com.example.store.controller;
import com.example.store.dto.OrderDto;
import com.example.store.dto.ProductDto;
import com.example.store.entity.Product;
import com.example.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/placeOrder")
    private Product placeOrder(@RequestBody OrderDto orderDto){
        return orderService.postorder(orderDto);
    }

}
