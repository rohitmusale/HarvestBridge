package com.harvestBridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harvestBridge.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
