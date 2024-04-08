package com.harvestBridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harvestBridge.entity.RecommendCrop;

@Repository
public interface RecommendCropRepository  extends JpaRepository<RecommendCrop, Integer>{

}
