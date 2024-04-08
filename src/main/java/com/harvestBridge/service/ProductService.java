package com.harvestBridge.service;

import java.util.List;

import com.harvestBridge.entity.Product;

public interface ProductService {
	Product createProduct(Product product);
	Product getProductById(int id);
	List<Product> getAllProduct();
	Product updateProduct(Product product);
	void deleteProduct(int id);
}
