package com.example.capacitacionJavaTienda.service;

import com.example.capacitacionJavaTienda.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository repository;
}
