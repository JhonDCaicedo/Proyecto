package com.example.capacitacionJavaTienda.service;

import com.example.capacitacionJavaTienda.domain.Sale;
import com.example.capacitacionJavaTienda.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
    @Autowired
    private SaleRepository repository;

    public Sale saveSale(Sale sale){
        return repository.save(sale);
    }
}
