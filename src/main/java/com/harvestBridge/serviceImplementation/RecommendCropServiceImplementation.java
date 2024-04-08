package com.harvestBridge.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harvestBridge.entity.RecommendCrop;
import com.harvestBridge.repository.RecommendCropRepository;
import com.harvestBridge.service.RecommendCropService;

@Service
public class RecommendCropServiceImplementation implements RecommendCropService{
	@Autowired
	RecommendCropRepository recommendCropRepo;
	
	@Override
	public RecommendCrop createRecommendCrop(RecommendCrop  recommendCrop) {
		RecommendCrop rc =  recommendCropRepo.save( recommendCrop);
		return rc;
	}

	@Override
	public  RecommendCrop getRecommendCropById(int id) {
		Optional<RecommendCrop> rc1 =  recommendCropRepo.findById(id);
		
		if(rc1.isPresent()) {
			return rc1.get();		
		}
		return null;
	}

	@Override
	public List<RecommendCrop> getAllRecommendCrop() {
		return  recommendCropRepo.findAll();
	}

	@Override
	public RecommendCrop updateRecommendCrop(RecommendCrop  recommendCrop) {
		 RecommendCrop existingRecommendCrop =  recommendCropRepo.findById( recommendCrop.getCRecomID()).get();
		existingRecommendCrop.setNitrogen( recommendCrop.getNitrogen());
		existingRecommendCrop.setPhosphorous( recommendCrop.getPhosphorous());
		existingRecommendCrop.setPotassium( recommendCrop.getPotassium());
		existingRecommendCrop.setPh( recommendCrop.getPh());
		existingRecommendCrop.setRainfall( recommendCrop.getRainfall());
		existingRecommendCrop.setTemp( recommendCrop.getTemp());
		existingRecommendCrop.setHumidity( recommendCrop.getHumidity());
		
		 RecommendCrop updateRecommendCrop =  recommendCropRepo.save(existingRecommendCrop);
		return updateRecommendCrop;
	}

	@Override
	public void deleteRecommendCrop(int id) {
		 recommendCropRepo.deleteById(id);
		
	}

	
}
