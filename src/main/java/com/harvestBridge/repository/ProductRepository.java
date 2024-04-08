package com.harvestBridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harvestBridge.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
