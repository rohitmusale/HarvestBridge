package com.harvestBridge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harvestBridge.entity.RecommendCrop;
import com.harvestBridge.service.RecommendCropService;

import jakarta.validation.Valid;

@RestController
public class RecommendCropController {
	@Autowired
	RecommendCropService recommendCropService;
	
	@PostMapping("/recommendCrop")
	public RecommendCrop saveRecommendCrop(@Valid @RequestBody RecommendCrop recommendCrop) {
		return recommendCropService.createRecommendCrop(recommendCrop);
	}
	
	@GetMapping("/recommendCrop/{id}")
	public RecommendCrop getRecommendCropById(@PathVariable("id")int id) {
		return recommendCropService.getRecommendCropById(id);
	}
	
	@GetMapping("recommendCrop/getAllData")
	public List<RecommendCrop> getAllRecommendCrop(){
		List<RecommendCrop> recommendCrop = recommendCropService.getAllRecommendCrop();
		return recommendCrop;
	}
	
	@PutMapping("/recommendCrop/update/{id}")
	public RecommendCrop updateRecommendCrop(@PathVariable("id") int id, @RequestBody RecommendCrop recommendCrop) {
		recommendCrop.setCRecomID(id);
		RecommendCrop updateRecommendCrop = recommendCropService.updateRecommendCrop(recommendCrop);
		return updateRecommendCrop;
	}
	
	@DeleteMapping("/recommendCrop/delete/{id}")
	public void deleteRecommendCrop(@PathVariable int id) {
		recommendCropService.deleteRecommendCrop(id);
		System.out.println("Delete from recommendCrop table Successfully");
	}
}
