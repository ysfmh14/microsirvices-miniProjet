package com.example.ReviewService.OpenFeign;

import com.example.ReviewService.Entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "recommendation-service" , url = "http://localhost:7002")
public interface ProductRestController {
    @GetMapping(path = "/products/{id}")
    Product findProductById(@PathVariable int id);
}
