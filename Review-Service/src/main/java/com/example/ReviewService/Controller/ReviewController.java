package com.example.ReviewService.Controller;

import com.example.ReviewService.Controller.api.ReviewApi;
import com.example.ReviewService.DTO.ReviewRequestDto;
import com.example.ReviewService.DTO.ReviewResponseDTO;
import com.example.ReviewService.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ReviewController  implements ReviewApi {
     private ReviewService reviewService;
    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Override
    public List<ReviewResponseDTO> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @Override
    public ReviewResponseDTO getReviewById(long id) {
        return reviewService.getReviewById(id);
    }

    @Override
    public ReviewResponseDTO save(ReviewRequestDto reviewRequestDto) {
        return reviewService.addReview(reviewRequestDto);
    }

    @Override
    public ReviewResponseDTO update(long id, ReviewRequestDto reviewRequestDto) {
        return reviewService.UpdateReview(reviewRequestDto);
    }

    @Override
    public void delete(long id) {
           reviewService.deleteReview(id);
    }
}
