package com.harvestBridge.service;

import java.util.List;

import com.harvestBridge.entity.RecommendPesticide;

public interface RecommendPesticideService {
	RecommendPesticide createRecommendPesticide(RecommendPesticide recommendPesticide);
	RecommendPesticide getRecommendPesticideById(int id);
	List<RecommendPesticide> getAllRecommendPesticide();
	RecommendPesticide updateRecommendPesticide(RecommendPesticide recommendPesticide);
	void deleteRecommendPesticide(int id);
}
