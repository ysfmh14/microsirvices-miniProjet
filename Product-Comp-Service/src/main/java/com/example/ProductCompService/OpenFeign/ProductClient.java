package com.example.ProductCompService.OpenFeign;

import com.example.ProductCompService.Entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "product-service" )
public interface ProductClient {
    @GetMapping("/api/v1/products")
    public List<Product> getProducts();
}
