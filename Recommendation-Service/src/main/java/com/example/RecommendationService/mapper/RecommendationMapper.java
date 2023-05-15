package com.example.RecommendationService.mapper;

import com.example.RecommendationService.dto.RequestRecommendationDto;
import com.example.RecommendationService.dto.ResponseRecommendationDto;
import com.example.RecommendationService.entity.Recommandation;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
@Service
public interface RecommendationMapper {
    ResponseRecommendationDto modelToDto(Recommandation recommandation);
    List<ResponseRecommendationDto> modelToDtos(List<Recommandation> recommandations);
    Recommandation dtoToModule(RequestRecommendationDto requestRecommendationDto);

}
