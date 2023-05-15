package com.example.ReviewService.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewRequestDto {
    private long reviewId;
    private String author;
    private  String subject;
    private String content;
    private int productInt;
}
