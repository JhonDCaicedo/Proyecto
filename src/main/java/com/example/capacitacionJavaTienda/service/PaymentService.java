package com.example.capacitacionJavaTienda.service;

import com.example.capacitacionJavaTienda.domain.Payment;
import com.example.capacitacionJavaTienda.domain.Product;
import com.example.capacitacionJavaTienda.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository repository;

    public List<Payment> findAllPayment (){
        return repository.findAll();
    }

    public Payment savePayment(Payment payment){
        return repository.save(payment);
    }

    public boolean deleteByIdPayment(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public Payment findByIdPayment(Long id){
        Payment o = null;

        if(repository.findById(id).isPresent()){
            o = repository.findById(id).get();
        }

        return o;
    }
}
