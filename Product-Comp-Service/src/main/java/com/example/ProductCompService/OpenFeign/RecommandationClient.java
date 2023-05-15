package com.example.ProductCompService.OpenFeign;

import com.example.ProductCompService.Entities.Recommandation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "recommendation-service" , url = "http://localhost:7003")
public interface RecommandationClient {
    @GetMapping("/api/v1/recommendations/{productId}")
    public List<Recommandation> getRecommandationsByProduct(@PathVariable int productId);
}
