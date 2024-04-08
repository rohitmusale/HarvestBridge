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

import com.harvestBridge.entity.Farmer;
import com.harvestBridge.service.FarmerService;

import jakarta.validation.Valid;

@RestController
public class FarmerController {
	@Autowired
	FarmerService farmerService;
	
	@PostMapping("/farmer")
	public Farmer saveFarmer(@Valid @RequestBody Farmer farmer) {
		return farmerService.createFarmer(farmer);
	}
	
	@GetMapping("/farmer/{id}")
	public Farmer getFarmerById(@PathVariable("id")int id) {
		return farmerService.getFarmerById(id);
	}
	
	@GetMapping("farmer/getAllData")
	public List<Farmer> getAllFarmer(){
		List<Farmer> farmer = farmerService.getAllFarmer();
		return farmer;
	}
	
	@PutMapping("/farmer/update/{id}")
	public Farmer updateFarmer(@PathVariable("id") int id, @RequestBody Farmer farmer) {
		farmer.setFID(id);
		Farmer updateFarmer = farmerService.updateFarmer(farmer);
		return updateFarmer;
	}
	
	@DeleteMapping("/farmer/delete/{id}")
	public void deleteFarmer(@PathVariable int id) {
		farmerService.deleteFarmer(id);
		System.out.println("Delete from farmer table Successfully");
	}
}
