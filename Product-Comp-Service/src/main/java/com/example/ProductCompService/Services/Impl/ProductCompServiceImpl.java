package com.example.ProductCompService.Services.Impl;

import com.example.ProductCompService.Entities.Product;
import com.example.ProductCompService.Entities.Recommandation;
import com.example.ProductCompService.Entities.Reviews;
import com.example.ProductCompService.OpenFeign.ProductClient;
import com.example.ProductCompService.OpenFeign.RecommandationClient;
import com.example.ProductCompService.OpenFeign.ReviewClient;
import com.example.ProductCompService.Services.ProductCompService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductCompServiceImpl implements ProductCompService {
    private ReviewClient reviewClient;
    private RecommandationClient recommandationClient;
    private ProductClient productClient;
    @Autowired
    public ProductCompServiceImpl(ReviewClient reviewClient,ProductClient productClient, RecommandationClient recommandationClient) {
        this.reviewClient = reviewClient;
        this.productClient = productClient;
        this.recommandationClient = recommandationClient;
    }
    @CircuitBreaker(name = "product-circuitbreaker" , fallbackMethod = "fallbackGetReviewsByProduct")
    @Override
    public List<Reviews> getReviewsByProduct(int id) {
        return reviewClient.getReviewsByProduct(id);
    }
    public List<Reviews> fallbackGetReviewsByProduct(Exception e) {
        List<Reviews> reviewsList = new ArrayList<Reviews>();
        return reviewsList;
    }

    @CircuitBreaker(name = "product-circuitbreaker" , fallbackMethod = "fallbackGetRecommandationsByProduct")
    @Override
    public List<Recommandation> getRecommandationsByProduct(int id) {
        return recommandationClient.getRecommandationsByProduct(id);
    }
    public List<Recommandation> allbackGetRecommandationsByProduct(Exception e) {
        List<Recommandation> recommandationList = new ArrayList<Recommandation>();
        return recommandationList;
    }
    @CircuitBreaker(name = "product-circuitbreaker" , fallbackMethod = "fallbackGetAllProduct")
    @Override
    public List<Product> getAllProducts() {
        return productClient.getProducts();
    }
    public List<Product> fallbackGetAllProduct(Exception e) {
        List<Product> productList = new ArrayList<Product>();
        return productList;
    }
}
