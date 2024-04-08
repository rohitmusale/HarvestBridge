package com.harvestBridge.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harvestBridge.entity.RecommendFertilizer;
import com.harvestBridge.repository.RecommendFertilizerRepository;
import com.harvestBridge.service.RecommendFertilizerService;

@Service
public class RecommendFertilizerServiceImplementation implements RecommendFertilizerService{
	@Autowired
	RecommendFertilizerRepository recommendFertilizerRepo;
	
	@Override
	public RecommendFertilizer createRecommendFertilizer(RecommendFertilizer  recommendFertilizer) {
		RecommendFertilizer rf =  recommendFertilizerRepo.save( recommendFertilizer);
		return rf;
	}

	@Override
	public  RecommendFertilizer getRecommendFertilizerById(int id) {
		Optional<RecommendFertilizer> rf1 =  recommendFertilizerRepo.findById(id);
		
		if(rf1.isPresent()) {
			return rf1.get();		
		}
		return null;
	}

	@Override
	public List<RecommendFertilizer> getAllRecommendFertilizer() {
		return  recommendFertilizerRepo.findAll();
	}

	@Override
	public RecommendFertilizer updateRecommendFertilizer(RecommendFertilizer  recommendFertilizer) {
		RecommendFertilizer existingRecommendFertilizer =  recommendFertilizerRepo.findById( recommendFertilizer.getFRecomID()).get();
		existingRecommendFertilizer.setNitrogen( recommendFertilizer.getNitrogen());
		existingRecommendFertilizer.setPhosphorous( recommendFertilizer.getPhosphorous());
		existingRecommendFertilizer.setPotassium( recommendFertilizer.getPotassium());
		existingRecommendFertilizer.setCrop( recommendFertilizer.getCrop());
		
		
		RecommendFertilizer updateRecommendFertilizer =  recommendFertilizerRepo.save(existingRecommendFertilizer);
		return updateRecommendFertilizer;
	}

	@Override
	public void deleteRecommendFertilizer(int id) {
		 recommendFertilizerRepo.deleteById(id);
		
	}

}
