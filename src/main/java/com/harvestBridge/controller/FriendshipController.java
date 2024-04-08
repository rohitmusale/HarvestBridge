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

import com.harvestBridge.entity.Friendship;
import com.harvestBridge.service.FriendshipService;

import jakarta.validation.Valid;

@RestController
public class FriendshipController {
	@Autowired
	FriendshipService friendshipService;
	
	@PostMapping("/friendship")
	public Friendship saveFriendship(@Valid @RequestBody Friendship friendship) {
		return friendshipService.createFriendship(friendship);
	}
	
	@GetMapping("/friendship/{id}")
	public Friendship getFriendshipById(@PathVariable("id")int id) {
		return friendshipService.getFriendshipById(id);
	}
	
	@GetMapping("friendship/getAllData")
	public List<Friendship> getAllFriendship(){
		List<Friendship> friendship = friendshipService.getAllFriendship();
		return friendship;
	}
	
	@PutMapping("/friendship/update/{id}")
	public Friendship updateFriendship(@PathVariable("id") int id, @RequestBody Friendship friendship) {
		friendship.setFrdID(id);
		Friendship updateFriendship = friendshipService.updateFriendship(friendship);
		return updateFriendship;
	}
	
	@DeleteMapping("/friendship/delete/{id}")
	public void deleteFriendship(@PathVariable int id) {
		friendshipService.deleteFriendship(id);
		System.out.println("Delete from friendship table Successfully");
	}
}
