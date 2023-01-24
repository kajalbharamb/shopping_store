package com.example.store.dto.response;

import com.example.store.entity.Sales;

import java.util.List;

public class SaleResponse extends ApiResponse{
    private List<Sales> salesList;


    public SaleResponse(int statusCode, String message, List<Sales> salesList) {
        super(statusCode, message);
        this.salesList = salesList;
    }
}
