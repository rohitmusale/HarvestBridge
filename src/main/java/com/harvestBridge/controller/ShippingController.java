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

import com.harvestBridge.entity.Shipping;
import com.harvestBridge.service.ShippingService;

import jakarta.validation.Valid;

@RestController
public class ShippingController {
	@Autowired
	ShippingService shippingService;
	
	@PostMapping("/shipping")
	public Shipping saveShipping(@Valid @RequestBody Shipping shipping) {
		return shippingService.createShipping(shipping);
	}
	
	@GetMapping("/shipping/{id}")
	public Shipping getShippingById(@PathVariable("id")int id) {
		return shippingService.getShippingById(id);
	}
	
	@GetMapping("shipping/getAllData")
	public List<Shipping> getAllShipping(){
		List<Shipping> shipping = shippingService.getAllShipping();
		return shipping;
	}
	
	@PutMapping("/shipping/update/{id}")
	public Shipping updateShipping(@PathVariable("id") int id, @RequestBody Shipping shipping) {
		shipping.setSID(id);
		Shipping updateShipping = shippingService.updateShipping(shipping);
		return updateShipping;
	}
	
	@DeleteMapping("/shipping/delete/{id}")
	public void deleteShipping(@PathVariable int id) {
		shippingService.deleteShipping(id);
		System.out.println("Delete from shipping table Successfully");
	}
}
