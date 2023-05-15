package com.example.ReviewService.Entities;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewId;
    private String author;
    private  String subject;
    private String content;
    private int productInt;
    @Transient
    private  Product product;
}
