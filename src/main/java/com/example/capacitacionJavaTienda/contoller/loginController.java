package com.example.capacitacionJavaTienda.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class loginController {

    @GetMapping
    public String login(){
        return "login";
    }

    @GetMapping("/createAccount")
    public String loginCreateAccount(){
        return "createAccount";
    }

}