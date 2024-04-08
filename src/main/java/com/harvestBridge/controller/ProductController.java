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

import com.harvestBridge.entity.Product;
import com.harvestBridge.service.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
	@PostMapping("/product")
	public Product saveProduct(@Valid @RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable("id")int id) {
		return productService.getProductById(id);
	}
	
	@GetMapping("product/getAllData")
	public List<Product> getAllProduct(){
		List<Product> product = productService.getAllProduct();
		return product;
	}
	
	@PutMapping("/product/update/{id}")
	public Product updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
		product.setPrID(id);
		Product updateProduct= productService.updateProduct(product);
		return updateProduct;
	}
	
	@DeleteMapping("/product/delete/{id}")
	public void deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
		System.out.println("Delete from product table Successfully");
	}
}
