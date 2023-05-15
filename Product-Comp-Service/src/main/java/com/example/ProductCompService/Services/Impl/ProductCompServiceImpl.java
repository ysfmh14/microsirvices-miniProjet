package com.example.ProductCompService.Services.Impl;

import com.example.ProductCompService.Entities.Recommandation;
import com.example.ProductCompService.Entities.Reviews;
import com.example.ProductCompService.OpenFeign.RecommandationClient;
import com.example.ProductCompService.OpenFeign.ReviewClient;
import com.example.ProductCompService.Services.ProductCompService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductCompServiceImpl implements ProductCompService {
    private ReviewClient reviewClient;
    private RecommandationClient recommandationClient;
    @Autowired
    public ProductCompServiceImpl(ReviewClient reviewClient, RecommandationClient recommandationClient) {
        this.reviewClient = reviewClient;
        this.recommandationClient = recommandationClient;
    }

    @Override
    public List<Reviews> getReviewsByProduct(int id) {
        return reviewClient.getReviewsByProduct(id);
    }

    @Override
    public List<Recommandation> getRecommandationsByProduct(int id) {
        return recommandationClient.getRecommandationsByProduct(id);
    }
}
