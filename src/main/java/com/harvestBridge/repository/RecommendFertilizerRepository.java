package com.harvestBridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harvestBridge.entity.RecommendFertilizer;

@Repository
public interface RecommendFertilizerRepository extends JpaRepository<RecommendFertilizer, Integer> {

}
