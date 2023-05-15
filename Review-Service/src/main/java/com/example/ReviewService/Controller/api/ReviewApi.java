package com.example.ReviewService.Controller.api;

import com.example.ReviewService.DTO.ReviewRequestDto;
import com.example.ReviewService.DTO.ReviewResponseDTO;
import com.example.ReviewService.Services.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/reviews")
public interface ReviewApi {
    @GetMapping
    List<ReviewResponseDTO> getAllReviews();


    @GetMapping("/{id}")
    ReviewResponseDTO getReviewById(@PathVariable(name = "id") long id);
    @GetMapping("/product/{id}")
   List< ReviewResponseDTO> getReviewsByProduct(@PathVariable(name = "id") int id);

    @PostMapping
    ReviewResponseDTO save(@RequestBody ReviewRequestDto reviewRequestDto);


    @PutMapping ("/{id}")
    ReviewResponseDTO update(@PathVariable(name = "id") long id ,@RequestBody ReviewRequestDto reviewRequestDto);


    @DeleteMapping("/{id}")
    void delete(@PathVariable(name = "id") long id);

}
