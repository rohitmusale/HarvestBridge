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

import com.harvestBridge.entity.RecommendPesticide;
import com.harvestBridge.service.RecommendPesticideService;

import jakarta.validation.Valid;

@RestController
public class RecommendPesticideController {
	@Autowired
	RecommendPesticideService recommendPesticideService;
	
	@PostMapping("/recommendPesticide")
	public RecommendPesticide saveRecommendPesticide(@Valid @RequestBody RecommendPesticide recommendPesticide) {
		return recommendPesticideService.createRecommendPesticide(recommendPesticide);
	}
	
	@GetMapping("/recommendPesticide/{id}")
	public RecommendPesticide getRecommendPesticideById(@PathVariable("id")int id) {
		return recommendPesticideService.getRecommendPesticideById(id);
	}
	
	@GetMapping("recommendPesticide/getAllData")
	public List<RecommendPesticide> getAllRecommendPesticide(){
		List<RecommendPesticide> recommendPesticide = recommendPesticideService.getAllRecommendPesticide();
		return recommendPesticide;
	}
	
	@PutMapping("/recommendPesticide/update/{id}")
	public RecommendPesticide updateRecommendPesticide(@PathVariable("id") int id, @RequestBody RecommendPesticide recommendPesticide) {
		recommendPesticide.setPRecomID(id);
		RecommendPesticide updateRecommendPesticide = recommendPesticideService.updateRecommendPesticide(recommendPesticide);
		return updateRecommendPesticide;
	}
	
	@DeleteMapping("/recommendPesticide/delete/{id}")
	public void deleteRecommenPesticide(@PathVariable int id) {
		recommendPesticideService.deleteRecommendPesticide(id);
		System.out.println("Delete from recommendFertilizer table Successfully");
	}
}
