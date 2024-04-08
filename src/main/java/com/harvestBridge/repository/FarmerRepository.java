package com.harvestBridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harvestBridge.entity.Farmer;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Integer> {

}
