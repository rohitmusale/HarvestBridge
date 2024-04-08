package com.harvestBridge.service;

import java.util.List;

import com.harvestBridge.entity.RecommendCrop;

public interface RecommendCropService{
	RecommendCrop createRecommendCrop(RecommendCrop recommendCrop);
	RecommendCrop getRecommendCropById(int id);
	List<RecommendCrop> getAllRecommendCrop();
	RecommendCrop updateRecommendCrop(RecommendCrop recommendCrop);
	void deleteRecommendCrop(int id);
}
