package com.example.capacitacionJavaTienda.service;

import com.example.capacitacionJavaTienda.domain.Product;
import com.example.capacitacionJavaTienda.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAllProduct(){
        return repository.findAll();
    }

    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public boolean deleteByIdProduct(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public Product findByIdProduct(Long id){
        Product o = null;

        if(repository.findById(id).isPresent()){
            o = repository.findById(id).get();
        }

        return o;
    }
}
