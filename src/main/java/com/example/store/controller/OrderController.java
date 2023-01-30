package com.example.store.controller;

import com.example.store.dto.request.OrderDto;
import com.example.store.dto.response.OrderResponse;
import com.example.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    private ResponseEntity<OrderResponse> placeOrder(@Valid @RequestBody OrderDto orderDto) {
        return ResponseEntity.ok(new OrderResponse(HttpStatus.ACCEPTED.value(), "Order Placed", orderService.postorder(orderDto)));
    }

}
