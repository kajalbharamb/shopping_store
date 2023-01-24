package com.example.store.controller;
import com.example.store.dto.response.SaleResponse;
import com.example.store.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
public class SalesController {
    @Autowired
    private SalesService salesService;

    @GetMapping("/list")
    public ResponseEntity<SaleResponse> getSales(){
        return new ResponseEntity<>(new SaleResponse(HttpStatus.ACCEPTED.value(), "Sales list", salesService.getListOfSales()), HttpStatus.ACCEPTED);
    }

}
