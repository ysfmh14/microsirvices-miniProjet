package com.example.ProductCompService.OpenFeign;

import com.example.ProductCompService.Entities.Reviews;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "review-service")
public interface ReviewClient {
    @GetMapping("api/v1/reviews/product/{id}")
    List<Reviews> getReviewsByProduct(@PathVariable(name = "id") int id);
}
