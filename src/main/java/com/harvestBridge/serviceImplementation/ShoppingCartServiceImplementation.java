package com.harvestBridge.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harvestBridge.entity.ShoppingCart;
import com.harvestBridge.repository.ShoppingCartRepository;
import com.harvestBridge.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImplementation implements ShoppingCartService {
	@Autowired
	ShoppingCartRepository shoppingCartRepo;
	
	@Override
	public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
		ShoppingCart sc = shoppingCartRepo.save(shoppingCart);
		return sc;
	}

	@Override
	public ShoppingCart getShoppingCartById(int id) {
		Optional<ShoppingCart> sc1 = shoppingCartRepo.findById(id);
		
		if(sc1.isPresent()) {
			return sc1.get();		
		}
		return null;
	}

	@Override
	public List<ShoppingCart> getAllShoppingCart() {
		return shoppingCartRepo.findAll();
	}

	@Override
	public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
		ShoppingCart existingShoppingCart = shoppingCartRepo.findById(shoppingCart.getScID()).get();
		existingShoppingCart.setPrdQuantity(shoppingCart.getPrdQuantity());
		existingShoppingCart.setPrdTotalPrice(shoppingCart.getPrdTotalPrice());
		
		
		ShoppingCart updateShoppingCart = shoppingCartRepo.save(existingShoppingCart);
		return updateShoppingCart;
	}

	@Override
	public void deleteShoppingCart(int id) {
		shoppingCartRepo.deleteById(id);
		
	}
}
