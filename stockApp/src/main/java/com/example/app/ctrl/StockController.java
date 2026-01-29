package com.example.app.ctrl;

import com.example.app.producer.StockProducer;
import com.example.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
public class StockController {

    @Autowired
    private ProductService productService;

    private final StockProducer stockProducer;

    public StockController(StockProducer stockProducer) {
        this.stockProducer = stockProducer;
    }

    @PostMapping("/messages")
    public void produceMessage(@RequestBody String message) {
        stockProducer.produce(message);
    }

    @GetMapping("/home")
    public ModelAndView home(){
        return new ModelAndView("home", Map.of("products",productService.allProducts()));
    }
}
