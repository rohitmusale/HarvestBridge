package com.harvestBridge.service;

import java.util.List;

import com.harvestBridge.entity.Shipping;

public interface ShippingService {
	Shipping createShipping(Shipping shipping);
	Shipping getShippingById(int id);
	List<Shipping> getAllShipping();
	Shipping updateShipping(Shipping shipping);
	void deleteShipping(int id);
}
