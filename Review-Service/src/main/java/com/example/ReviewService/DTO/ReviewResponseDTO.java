package com.example.ReviewService.DTO;

import com.example.ReviewService.Entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewResponseDTO {
    private long reviewId;
    private String author;
    private  String subject;
    private String content;
    private Product product;
}
