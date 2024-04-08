package com.harvestBridge.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.harvestBridge.entity.Farmer;
import com.harvestBridge.repository.FarmerRepository;
import com.harvestBridge.service.FarmerService;

@Service
public class FarmerServiceImplementation implements FarmerService{
	@Autowired
	FarmerRepository farmerRepo;
	
	@Override
	public Farmer createFarmer(Farmer farmer) {
		Farmer frm = farmerRepo.save(farmer);
		return frm;
	}

	@Override
	public Farmer getFarmerById(int id) {
		Optional<Farmer> frm1 = farmerRepo.findById(id);
		
		if(frm1.isPresent()) {
			return frm1.get();		
		}
		return null;
	}

	@Override
	public List<Farmer> getAllFarmer() {
		return farmerRepo.findAll();
	}

	@Override
	public Farmer updateFarmer(Farmer farmer) {
		Farmer existingFarmer = farmerRepo.findById(farmer.getFID()).get();
		existingFarmer.setFName(farmer.getFName());
		existingFarmer.setFEmail(farmer.getFEmail());
		existingFarmer.setFMobNo(farmer.getFMobNo());
		existingFarmer.setFAddress(farmer.getFAddress());
		
		Farmer updateFarmer = farmerRepo.save(existingFarmer);
		return updateFarmer;
	}

	@Override
	public void deleteFarmer(int id) {
		farmerRepo.deleteById(id);
		
	}

}
