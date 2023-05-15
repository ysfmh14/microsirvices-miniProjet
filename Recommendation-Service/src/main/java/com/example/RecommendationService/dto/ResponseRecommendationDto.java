package com.example.RecommendationService.dto;

import com.example.RecommendationService.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseRecommendationDto {
    private  int recommendationId;
    private String author;
    private int rate;
    private String content;
    private Product product;
}
