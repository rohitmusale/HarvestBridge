package com.harvestBridge.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harvestBridge.entity.Shipping;
import com.harvestBridge.repository.ShippingRepository;
import com.harvestBridge.service.ShippingService;

@Service
public class ShippingServiceImplementation implements ShippingService {
	@Autowired
	ShippingRepository shippingRepo;
	
	@Override
	public Shipping createShipping(Shipping shipping) {
		Shipping shp = shippingRepo.save(shipping);
		return shp;
	}

	@Override
	public Shipping getShippingById(int id) {
		Optional<Shipping> shp1 = shippingRepo.findById(id);
		
		if(shp1.isPresent()) {
			return shp1.get();		
		}
		return null;
	}

	@Override
	public List<Shipping> getAllShipping() {
		return shippingRepo.findAll();
	}

	@Override
	public Shipping updateShipping(Shipping shipping) {
		Shipping existingShipping = shippingRepo.findById(shipping.getSID()).get();
		existingShipping.setSAddress(shipping.getSAddress());
		
		
		Shipping updateShipping = shippingRepo.save(existingShipping);
		return updateShipping;
	}

	@Override
	public void deleteShipping(int id) {
		shippingRepo.deleteById(id);
		
	}
}
