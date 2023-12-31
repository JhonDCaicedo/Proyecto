package com.example.capacitacionJavaTienda.service;

import com.example.capacitacionJavaTienda.domain.Category;
import com.example.capacitacionJavaTienda.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAllCategory (){
        return repository.findAll();
    }

    public Category saveCategory(Category Category){
        return repository.save(Category);
    }

    public boolean deleteByIdCategory(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public Category findByIdCategory(Long id){
        Category o = null;

        if(repository.findById(id).isPresent()){
            o = repository.findById(id).get();
        }

        return o;
    }
}
