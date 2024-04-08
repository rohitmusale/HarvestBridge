package com.harvestBridge.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harvestBridge.entity.Product;
import com.harvestBridge.repository.ProductRepository;
import com.harvestBridge.service.ProductService;

@Service
public class ProductServiceImplementation implements ProductService {
	@Autowired
	ProductRepository productRepo;
	
	@Override
	public Product createProduct(Product product) {
		Product prd = productRepo.save(product);
		return prd;
	}

	@Override
	public Product getProductById(int id) {
		Optional<Product> prd1 = productRepo.findById(id);
		
		if(prd1.isPresent()) {
			return prd1.get();		
		}
		return null;
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product updateProduct(Product product) {
		Product existingProduct = productRepo.findById(product.getPrID()).get();
		existingProduct.setPrImg(product.getPrImg());
		existingProduct.setPrName(product.getPrName());
		existingProduct.setPrPrice(product.getPrPrice());
		
		Product updateProduct = productRepo.save(existingProduct);
		return updateProduct;
	}

	@Override
	public void deleteProduct(int id) {
		productRepo.deleteById(id);
		
	}
}
