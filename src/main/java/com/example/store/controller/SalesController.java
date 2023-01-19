package com.example.store.controller;

import com.example.store.entity.Sales;
import com.example.store.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping("/list")
    public List<Sales> getSales(){
        return salesService.getListOfSales();
    }

}
