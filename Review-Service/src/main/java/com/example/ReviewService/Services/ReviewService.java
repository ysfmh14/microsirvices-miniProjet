package com.example.ReviewService.Services;

import com.example.ReviewService.DTO.ReviewRequestDto;
import com.example.ReviewService.DTO.ReviewResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ReviewService {
    List<ReviewResponseDTO> getAllReviews();
    ReviewResponseDTO getReviewById(long id) ;
    ReviewResponseDTO addReview(ReviewRequestDto reviewRequestDto);
    ReviewResponseDTO UpdateReview(ReviewRequestDto reviewRequestDto);
    ReviewResponseDTO saveReview(ReviewRequestDto reviewRequestDto);
    List<ReviewResponseDTO> getReviewsByProduct(int id);
    void  deleteReview(long reviewId);
}
