package com.example.RecommendationService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Recommandation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int recommendationId;
    private String author;
    private int rate;
    private String content;
    private int productId;
    @Transient
    private Product product;
}
