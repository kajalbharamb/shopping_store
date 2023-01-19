package com.example.store.service;
import com.example.store.entity.Sales;
import com.example.store.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    public List<Sales> getListOfSales() {
        return salesRepository.findAll();
    }
}
