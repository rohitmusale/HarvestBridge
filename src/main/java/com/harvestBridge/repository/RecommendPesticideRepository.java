package com.harvestBridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harvestBridge.entity.RecommendPesticide;

@Repository
public interface RecommendPesticideRepository extends JpaRepository<RecommendPesticide, Integer>{

}
