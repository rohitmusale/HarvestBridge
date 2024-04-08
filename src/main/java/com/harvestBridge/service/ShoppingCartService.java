package com.harvestBridge.service;

import java.util.List;

import com.harvestBridge.entity.ShoppingCart;

public interface ShoppingCartService {
	ShoppingCart createShoppingCart(ShoppingCart shoppingCart);
	ShoppingCart getShoppingCartById(int id);
	List<ShoppingCart> getAllShoppingCart();
	ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);
	void deleteShoppingCart(int id);
}
