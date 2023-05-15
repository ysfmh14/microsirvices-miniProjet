package com.example.RecommendationService.service;

import com.example.RecommendationService.dao.RecommandationDao;
import com.example.RecommendationService.dto.ResponseRecommendationDto;
import com.example.RecommendationService.entity.Recommandation;
import com.example.RecommendationService.mapper.RecommendationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommandationImpl implements RecommandationService{
    private final RecommendationMapper recommendationMapper;
    private final RecommandationDao recommandationDao;
    @Override
    public List<ResponseRecommendationDto> getRecommandationsByProduct(int productId) {
        List<Recommandation> recommandations=recommandationDao.getRecommandationsByPorduct(productId);
        return recommendationMapper.modelToDtos(recommandations);
    }
}
