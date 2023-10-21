package com.example.capacitacionJavaTienda.repository;

import com.example.capacitacionJavaTienda.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
