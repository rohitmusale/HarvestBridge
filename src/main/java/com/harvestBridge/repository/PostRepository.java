package com.harvestBridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harvestBridge.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
