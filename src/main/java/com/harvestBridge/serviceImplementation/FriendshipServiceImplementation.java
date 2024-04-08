package com.harvestBridge.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harvestBridge.entity.Friendship;
import com.harvestBridge.repository.FriendshipRepository;
import com.harvestBridge.service.FriendshipService;

@Service
public class FriendshipServiceImplementation implements FriendshipService {
	@Autowired
	FriendshipRepository friendshipRepo;
	
	@Override
	public Friendship createFriendship(Friendship friendship) {
		Friendship frd = friendshipRepo.save(friendship);
		return frd;
	}

	@Override
	public Friendship getFriendshipById(int id) {
		Optional<Friendship> frd1 = friendshipRepo.findById(id);
		
		if(frd1.isPresent()) {
			return frd1.get();		
		}
		return null;
	}

	@Override
	public List<Friendship> getAllFriendship() {
		return friendshipRepo.findAll();
	}

	@Override
	public Friendship updateFriendship(Friendship friendship) {
		Friendship existingFriendship = friendshipRepo.findById(friendship.getFrdID()).get();
		existingFriendship.setFrdName(friendship.getFrdName());
		
		Friendship updateFriendship = friendshipRepo.save(existingFriendship);
		return updateFriendship;
	}

	@Override
	public void deleteFriendship(int id) {
		friendshipRepo.deleteById(id);
		
	}
}
