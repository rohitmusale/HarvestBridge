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

import com.harvestBridge.entity.ShoppingCart;
import com.harvestBridge.service.ShoppingCartService;

import jakarta.validation.Valid;

@RestController
public class ShoppingCartController {
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@PostMapping("/shoppingCart")
	public ShoppingCart saveShoppingCart(@Valid @RequestBody ShoppingCart shoppingCart) {
		return shoppingCartService.createShoppingCart(shoppingCart);
	}
	
	@GetMapping("/shoppingCart/{id}")
	public ShoppingCart getShoppingCartById(@PathVariable("id")int id) {
		return shoppingCartService.getShoppingCartById(id);
	}
	
	@GetMapping("shoppingCart/getAllData")
	public List<ShoppingCart> getAllShoppingCart(){
		List<ShoppingCart> shoppingCart = shoppingCartService.getAllShoppingCart();
		return shoppingCart;
	}
	
	@PutMapping("/shoppingCart/update/{id}")
	public ShoppingCart updateShoppingCart(@PathVariable("id") int id, @RequestBody ShoppingCart shoppingCart) {
		shoppingCart.setScID(id);
		ShoppingCart updateShoppingCart = shoppingCartService.updateShoppingCart(shoppingCart);
		return updateShoppingCart;
	}
	
	@DeleteMapping("/shoppingCart/delete/{id}")
	public void deleteShoppingCart(@PathVariable int id) {
		shoppingCartService.deleteShoppingCart(id);
		System.out.println("Delete from shoppingCart table Successfully");
	}
}
