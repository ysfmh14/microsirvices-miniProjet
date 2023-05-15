package com.example.ProductCompService.Services;

import com.example.ProductCompService.Entities.Recommandation;
import com.example.ProductCompService.Entities.Reviews;

import java.util.List;

public interface ProductCompService {
    List<Reviews> getReviewsByProduct(int id);
    List<Recommandation> getRecommandationsByProduct(int id);
}
