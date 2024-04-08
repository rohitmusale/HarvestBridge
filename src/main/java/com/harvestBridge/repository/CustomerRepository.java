package com.harvestBridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harvestBridge.entity.Customer;




@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
