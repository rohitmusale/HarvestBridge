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

import com.harvestBridge.entity.RecommendFertilizer;
import com.harvestBridge.service.RecommendFertilizerService;

import jakarta.validation.Valid;

@RestController
public class RecommendFertilizerController {
	@Autowired
	RecommendFertilizerService recommendFertilizerService;
	
	@PostMapping("/recommendFertilizer")
	public RecommendFertilizer saveRecommendFertilizer(@Valid @RequestBody RecommendFertilizer recommendFertilizer) {
		return recommendFertilizerService.createRecommendFertilizer(recommendFertilizer);
	}
	
	@GetMapping("/recommendFertilizer/{id}")
	public RecommendFertilizer getRecommendFertilizerById(@PathVariable("id")int id) {
		return recommendFertilizerService.getRecommendFertilizerById(id);
	}
	
	@GetMapping("recommendFertilizer/getAllData")
	public List<RecommendFertilizer> getAllRecommendFertilizer(){
		List<RecommendFertilizer> recommendFertilizer = recommendFertilizerService.getAllRecommendFertilizer();
		return recommendFertilizer;
	}
	
	@PutMapping("/recommendFertilizer/update/{id}")
	public RecommendFertilizer updateRecommendFertilizer(@PathVariable("id") int id, @RequestBody RecommendFertilizer recommendFertilizer) {
		recommendFertilizer.setFRecomID(id);
		RecommendFertilizer updateRecommendFertilizer = recommendFertilizerService.updateRecommendFertilizer(recommendFertilizer);
		return updateRecommendFertilizer;
	}
	
	@DeleteMapping("/recommendFertilizer/delete/{id}")
	public void deleteRecommendFertilizer(@PathVariable int id) {
		recommendFertilizerService.deleteRecommendFertilizer(id);
		System.out.println("Delete from recommendFertilizer table Successfully");
	}
}
