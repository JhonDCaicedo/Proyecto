package com.example.capacitacionJavaTienda.repository;

import com.example.capacitacionJavaTienda.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
