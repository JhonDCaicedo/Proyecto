package com.example.capacitacionJavaTienda.contoller;

import com.example.capacitacionJavaTienda.domain.Payment;
import com.example.capacitacionJavaTienda.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService service;

    @GetMapping
    public String paymentInit(Model model){
        model.addAttribute("payment", new Payment());
        model.addAttribute("paymentList", service.findAllPayment());
        return "list_createPayment";
    }

    @GetMapping("/eliminar/{id}")
    public ModelAndView paymentDelete (@PathVariable(value="id") Long id){
        boolean res = service.deleteByIdPayment(id);
        return new ModelAndView("redirect:/payment");
    }

    @GetMapping("/update/{id}")
    public String paymentUpdate (@PathVariable(value="id") Long id, Model model){
        Payment payment = service.findByIdPayment(id);
        model.addAttribute("payment", payment);
        return "list_createPayment";
    }

    @PostMapping
    public ModelAndView paymentProduct (@ModelAttribute Payment payment, Model model){
        model.addAttribute("payment", payment);
        Payment p = service.savePayment(payment);
        return new ModelAndView("redirect:/payment");
    }

}
