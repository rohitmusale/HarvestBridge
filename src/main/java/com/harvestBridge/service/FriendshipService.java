package com.harvestBridge.service;

import java.util.List;

import com.harvestBridge.entity.Friendship;

public interface FriendshipService {
	Friendship createFriendship(Friendship friendship);
	Friendship getFriendshipById(int id);
	List<Friendship> getAllFriendship();
	Friendship updateFriendship(Friendship friendship);
	void deleteFriendship(int id);
}
