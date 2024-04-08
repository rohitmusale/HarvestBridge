package com.harvestBridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harvestBridge.entity.Shipping;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Integer> {

}
