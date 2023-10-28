package com.example.capacitacionJavaTienda.contoller;

import com.example.capacitacionJavaTienda.domain.Category;
import com.example.capacitacionJavaTienda.domain.Payment;
import com.example.capacitacionJavaTienda.domain.Product;
import com.example.capacitacionJavaTienda.domain.Sale;
import com.example.capacitacionJavaTienda.service.CategoryService;
import com.example.capacitacionJavaTienda.service.PaymentService;
import com.example.capacitacionJavaTienda.service.ProductService;
import com.example.capacitacionJavaTienda.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private ProductService service;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private SaleService  saleService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String store(Model model) {
        model.addAttribute("productList", service.findAllProduct());
        return "store";
    }

    @GetMapping("/product")
    public String storeproduct(Model model) {
        model.addAttribute("productList", service.findAllProduct());
        return "productList";
    }

    @GetMapping("/createProduct")
    public String storeCreateProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categoryList", categoryService.findAllCategory());
        return "createProduct";
    }

    @GetMapping("/eliminar/{id}")
    public ModelAndView storeProductDelete(@PathVariable(value = "id") Long id) {
        boolean res = service.deleteByIdProduct(id);
        return new ModelAndView("redirect:/store/product");
    }

    @GetMapping("/update/{id}")
    public String storeProductUpdate(@PathVariable(value = "id") Long id, Model model) {
        Product product = service.findByIdProduct(id);
        model.addAttribute("product", product);
        model.addAttribute("categoryList", categoryService.findAllCategory());
        return "createProduct";
    }

    @PostMapping("/createProduct")
    public ModelAndView storeCreateProduct(@ModelAttribute Product product,
                                           @RequestParam("idCategory") Long idcategory,
                                           Model model) {
        model.addAttribute("product", product);
        model.addAttribute("categoryList", categoryService.findAllCategory());
        Product p = service.saveProduct(product);
        Set<Category> hse = new HashSet<>();
        hse.add(categoryService.findByIdCategory(idcategory));
        p.setCategory(hse);
        System.out.println("Data: " + idcategory);
        service.saveProduct(p);
        return new ModelAndView("redirect:/store/product");
    }

    @GetMapping("/sale/{id}")
    public String storeProductSale(@PathVariable(value = "id") Long id, Model model) {
        Product product = service.findByIdProduct(id);
        model.addAttribute("product", product);
        model.addAttribute("paymentList", paymentService.findAllPayment());
        return "createSale";
    }

    @PostMapping("/sale")
    public ModelAndView SubmitSale (@RequestParam(value = "amountSale") Long amount,
                                     @RequestParam(value = "idPayment") Long idPayment,
                                     @RequestParam(value = "id") Long idProduct,
                                     Model model){

        System.out.println("Datos: " + amount + " / " + idPayment + " / " + idProduct );

        Product p = service.findByIdProduct(idProduct);
        if(amount <= p.getAmount()){
            p.setAmount( p.getAmount() - amount);
            service.saveProduct(p);
            Payment payment = paymentService.findByIdPayment(idPayment);
            Product product = service.findByIdProduct(idProduct);
            saleService.saveSale( new Sale(0L, amount, payment, product));
        }else{
            System.out.println("ERROR: Cantidad mayor...");
        }



        return new ModelAndView("redirect:/store");
    }


}
