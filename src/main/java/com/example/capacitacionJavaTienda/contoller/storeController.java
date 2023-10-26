package com.example.capacitacionJavaTienda.contoller;

import com.example.capacitacionJavaTienda.domain.Product;
import com.example.capacitacionJavaTienda.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/store")
public class storeController {

    @Autowired
    private ProductService service;

    @GetMapping
    public String store(Model model){
        model.addAttribute("productList", service.findAllProduct());
        return "store";
    }

    @GetMapping("/product")
    public String storeproduct(Model model){
        model.addAttribute("productList", service.findAllProduct());
        return "productList";
    }

    @GetMapping("/createProduct")
    public String storeCreateProduct(Model model){
        model.addAttribute("product", new Product());
        return "createProduct";
    }

    @GetMapping("/eliminar/{id}")
    public ModelAndView storeProductDelete (@PathVariable(value="id") Long id){
        boolean res = service.deleteByIdProduct(id);
        return new ModelAndView("redirect:/store/product");
    }

    @GetMapping("/update/{id}")
    public String storeProductUpdate (@PathVariable(value="id") Long id, Model model){
        Product product = service.findByIdUser(id);
        model.addAttribute("product", product);
        return "createProduct";
    }

    @PostMapping("/createProduct")
    public ModelAndView storeCreateProduct (@ModelAttribute Product product, Model model){
        model.addAttribute("product", product);
        Product p = service.saveProduct(product);
        return new ModelAndView("redirect:/store/product");
    }


}
