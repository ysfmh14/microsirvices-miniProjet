package com.example.ReviewService.Services.Impl;

import com.example.ReviewService.DAO.ReviewDAO;
import com.example.ReviewService.DTO.ReviewRequestDto;
import com.example.ReviewService.DTO.ReviewResponseDTO;
import com.example.ReviewService.Entities.Review;
import com.example.ReviewService.Exception.ReviewNotFoundException;
import com.example.ReviewService.Mappers.ReviewMapper;
import com.example.ReviewService.OpenFeign.ProductRestController;
import com.example.ReviewService.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewDAO reviewDAO;
    private ProductRestController productRestController;
    private ReviewMapper reviewMapper;
    @Autowired
    public ReviewServiceImpl(ReviewDAO reviewDAO , ProductRestController productRestController, ReviewMapper reviewMapper ) {
        this.reviewDAO = reviewDAO;
        this.productRestController= productRestController;
        this.reviewMapper = reviewMapper;
    }

    @Override
    public List<ReviewResponseDTO> getAllReviews() {
        List<Review> reviewList =reviewDAO.findAll();

       for (Review r : reviewList){
           r.setProduct(productRestController.getProductById(r.getProductInt()));
       }
        return reviewMapper.modelToDtos(reviewList);
    }

    @Override
    public ReviewResponseDTO getReviewById(long id) {
        Optional<Review> review =  reviewDAO.findById(id);
        if (!review.isPresent()){
                throw new ReviewNotFoundException("Il n' y a aucune review avec cet ID");
        }
        review.get().setProduct(productRestController.getProductById(review.get().getProductInt()));
        return reviewMapper.modelToDto(review.get());
    }

    @Override
    public ReviewResponseDTO addReview(ReviewRequestDto reviewRequestDto) {
      return saveReview(reviewRequestDto);
    }

    @Override
    public ReviewResponseDTO UpdateReview(ReviewRequestDto reviewRequestDto) {
        return saveReview(reviewRequestDto);
    }

    @Override
    public ReviewResponseDTO saveReview(ReviewRequestDto reviewRequestDto) {
        Review review = reviewMapper.dtoToModel(reviewRequestDto);
        Review savedReview = reviewDAO.save(review);
        return reviewMapper.modelToDto(savedReview);
    }

    @Override
    public List<ReviewResponseDTO> getReviewsByProduct(int id) {
        List<Review> reviewList = reviewDAO.findReviewsByProductInt(id);
        return reviewMapper.modelToDtos(reviewList);
    }

    @Override
    public void deleteReview(long reviewId) {
        reviewDAO.deleteById(reviewId);
    }
}
