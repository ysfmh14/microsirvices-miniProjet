package com.example.ReviewService.DAO;

import com.example.ReviewService.Entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDAO extends JpaRepository<Review, Long> {

    @Query("select r from Review r where r.productInt = ?1")
    List<Review>findReviewsByProductInt(int productInt);
}
