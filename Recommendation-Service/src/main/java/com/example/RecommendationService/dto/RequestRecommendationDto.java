package com.example.RecommendationService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RequestRecommendationDto {
    private  int recommendationId;
    private String author;
    private int rate;
    private String content;
    private int productId;

}
