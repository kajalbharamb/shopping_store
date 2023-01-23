package com.example.store.controller;
import com.example.store.dto.Login;
import com.example.store.dto.OrderDto;
import com.example.store.reponse.ActivityResponse;
import com.example.store.reponse.ApiResponse;
import com.example.store.reponse.ProductResponse;
import com.example.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private ResponseEntity<ProductResponse> placeOrder(@RequestBody OrderDto orderDto){
        return new ResponseEntity<>(new ProductResponse(HttpStatus.ACCEPTED.value(),"Order Placed",orderService.postorder(orderDto)),HttpStatus.ACCEPTED);
    }

}
