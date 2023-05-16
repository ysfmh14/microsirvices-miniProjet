package com.example.ProductCompService.Controller;

import com.example.ProductCompService.Entities.Product;
import com.example.ProductCompService.Entities.Recommandation;
import com.example.ProductCompService.Entities.Reviews;
import com.example.ProductCompService.Services.ProductCompService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductCompController {
    private ProductCompService productCompService;
    @Autowired
    public ProductCompController(ProductCompService productCompService) {
        this.productCompService = productCompService;
    }
    @GetMapping("/review/{id}")
    List<Reviews> getReviewsByProduct(@PathVariable(name = "id") int id){
        return productCompService.getReviewsByProduct(id);
    }
    @GetMapping("/recommendation/{id}")
    List<Recommandation> getRecommendationsByProduct(@PathVariable(name = "id") int id){
        return productCompService.getRecommandationsByProduct(id);
    }
    @GetMapping("/products")
    List<Product> getAllProducts(){
        return productCompService.getAllProducts();
    }

}
