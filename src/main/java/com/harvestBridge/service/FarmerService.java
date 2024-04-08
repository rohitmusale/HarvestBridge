package com.harvestBridge.service;

import java.util.List;

import com.harvestBridge.entity.Farmer;

public interface FarmerService {
	Farmer createFarmer(Farmer farmer);
	Farmer getFarmerById(int id);
	List<Farmer> getAllFarmer();
	Farmer updateFarmer(Farmer farmer);
	void deleteFarmer(int id);
}
