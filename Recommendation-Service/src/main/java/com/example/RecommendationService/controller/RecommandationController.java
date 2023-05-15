package com.example.RecommendationService.controller;

import com.example.RecommendationService.dto.ResponseRecommendationDto;
import com.example.RecommendationService.service.RecommandationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
@RequiredArgsConstructor
public class RecommandationController {
    private final RecommandationService recommandationService;
    @GetMapping("/{productId}")
    public List<ResponseRecommendationDto> getRecommandationsByProduct(@PathVariable int productId){
        return recommandationService.getRecommandationsByProduct(productId);
    }
}
