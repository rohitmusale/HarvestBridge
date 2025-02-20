package com.harvestBridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harvestBridge.entity.Friendship;

@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, Integer> {
	
}
