package com.example.RecommendationService.service;

import com.example.RecommendationService.dto.ResponseRecommendationDto;

import java.util.List;

public interface RecommandationService {
    List<ResponseRecommendationDto> getRecommandationsByProduct(int productId);
}
