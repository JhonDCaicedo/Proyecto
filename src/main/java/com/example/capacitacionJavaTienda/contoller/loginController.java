package com.example.capacitacionJavaTienda.contoller;

import com.example.capacitacionJavaTienda.domain.User;
import com.example.capacitacionJavaTienda.service.ProductService;
import com.example.capacitacionJavaTienda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class loginController {

    @Autowired
    private UserService service;
    @Autowired
    private ProductService productService;

    @GetMapping
    public String login(Model model){
        return "login";
    }

    @GetMapping("/createAccount")
    public String loginCreateAccount(Model model){
        model.addAttribute("user", new User());
        return "createAccount";
    }

    @PostMapping
    public ModelAndView SubmitLogin (@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, Model model){

        System.out.println("Datos: " + username + " / " + password );

        if(service.loadUserByUserName(username,password)){
            return new ModelAndView("redirect:/login/createAccount");
        }

        return new ModelAndView("redirect:/login");
    }

    @PostMapping("/createAccount")
    public ModelAndView submitCreateAccount(@ModelAttribute User user, Model model){
        model.addAttribute("user", user);
        User u = service.saveUser(user);
        return new ModelAndView("redirect:/login");
    }
}
