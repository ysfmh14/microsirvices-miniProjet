package com.example.RecommendationService.openFeign;

import com.example.RecommendationService.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "product-service" , url = "http://localhost:7000")

public interface ProductClient {
    @GetMapping(path = "/api/v1/products/{id}")
    Product getProductById(@PathVariable int id);
}
