package com.example.capacitacionJavaTienda.repository;

import com.example.capacitacionJavaTienda.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
