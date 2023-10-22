package com.example.capacitacionJavaTienda.service;

import com.example.capacitacionJavaTienda.domain.User;
import com.example.capacitacionJavaTienda.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user){
        return repository.save(user);
    }

    public boolean loadUserByUserName(String un, String pass){
        Optional<User> user  = repository.findByUsername(un);
        return user.map(value -> value.getPassword().equals(pass)).orElse(false);
    }

}
