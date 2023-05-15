package com.example.ProductCompService.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recommandation {
    private  int recommendationId;
    private String author;
    private int rate;
    private String content;
    private int productId;
}
