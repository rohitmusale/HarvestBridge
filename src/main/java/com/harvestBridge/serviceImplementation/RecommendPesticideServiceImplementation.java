package com.harvestBridge.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harvestBridge.entity.RecommendPesticide;
import com.harvestBridge.repository.RecommendPesticideRepository;
import com.harvestBridge.service.RecommendPesticideService;

@Service
public class RecommendPesticideServiceImplementation implements RecommendPesticideService{
	@Autowired
	RecommendPesticideRepository recommendPesticideRepo;
	
	@Override
	public RecommendPesticide createRecommendPesticide(RecommendPesticide  recommendPesticide) {
		RecommendPesticide rp =  recommendPesticideRepo.save( recommendPesticide);
		return rp;
	}

	@Override
	public  RecommendPesticide getRecommendPesticideById(int id) {
		Optional<RecommendPesticide> rp1 =  recommendPesticideRepo.findById(id);
		
		if(rp1.isPresent()) {
			return rp1.get();		
		}
		return null;
	}

	@Override
	public List<RecommendPesticide> getAllRecommendPesticide() {
		return  recommendPesticideRepo.findAll();
	}

	@Override
	public RecommendPesticide updateRecommendPesticide(RecommendPesticide  recommendPesticide) {
		RecommendPesticide existingRecommendPesticide =  recommendPesticideRepo.findById( recommendPesticide.getPRecomID()).get();
		existingRecommendPesticide.setCropIMG( recommendPesticide.getCropIMG());
		
		
		
		RecommendPesticide updateRecommendPesticide =  recommendPesticideRepo.save(existingRecommendPesticide);
		return updateRecommendPesticide;
	}

	@Override
	public void deleteRecommendPesticide(int id) {
		 recommendPesticideRepo.deleteById(id);
		
	}
}
