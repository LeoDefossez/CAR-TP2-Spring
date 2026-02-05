package com.example.app.ctrl;

import com.example.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@RestController
public class StockController {

    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public ModelAndView home(){
        return new ModelAndView("home", Map.of("products",productService.allProducts()));
    }

    @GetMapping("/home/resupply")
    public RedirectView resupply(){
        productService.resupply();
        return new RedirectView("/home");
    }
}
