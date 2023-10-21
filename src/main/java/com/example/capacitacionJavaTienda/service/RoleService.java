package com.example.capacitacionJavaTienda.service;

import com.example.capacitacionJavaTienda.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {

    @Autowired
    private RoleRepository repository;
}
