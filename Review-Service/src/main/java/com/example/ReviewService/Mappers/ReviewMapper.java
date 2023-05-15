package com.example.ReviewService.Mappers;

import com.example.ReviewService.DTO.ReviewRequestDto;
import com.example.ReviewService.DTO.ReviewResponseDTO;
import com.example.ReviewService.Entities.Review;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
@Service
public interface ReviewMapper {
    Review dtoToModel(ReviewRequestDto reviewRequestDto);

    ReviewResponseDTO modelToDto(Review review);

    List<ReviewResponseDTO > modelToDtos(List<Review > reviewList);
}
