package com.example.RecommendationService.dao;

import com.example.RecommendationService.entity.Recommandation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecommandationDao extends JpaRepository<Recommandation, Integer> {
    @Query("select r from Recommandation r where r.productId = ?1")
    List<Recommandation> getRecommandationsByPorduct(int productId);
}
