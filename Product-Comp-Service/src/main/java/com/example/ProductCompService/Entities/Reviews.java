package com.example.ProductCompService.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reviews {
    private long reviewId;
    private String author;
    private  String subject;
    private String content;
    private int productInt;
}
