package com.harvestBridge.service;

import java.util.List;


import com.harvestBridge.entity.RecommendFertilizer;

public interface RecommendFertilizerService {
	RecommendFertilizer createRecommendFertilizer(RecommendFertilizer recommendFertilizer);
	RecommendFertilizer getRecommendFertilizerById(int id);
	List<RecommendFertilizer> getAllRecommendFertilizer();
	RecommendFertilizer updateRecommendFertilizer(RecommendFertilizer recommendFertilizer);
	void deleteRecommendFertilizer(int id);
}
