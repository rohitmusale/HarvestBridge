package com.harvestBridge.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harvestBridge.entity.Post;
import com.harvestBridge.repository.PostRepository;
import com.harvestBridge.service.PostService;

@Service
public class PostServiceImplementation implements PostService{
	@Autowired
	PostRepository postRepo;
	
	@Override
	public Post createPost(Post post) {
		Post pst = postRepo.save(post);
		return pst;
	}

	@Override
	public Post getPostById(int id) {
		Optional<Post> pst1 = postRepo.findById(id);
		
		if(pst1.isPresent()) {
			return pst1.get();		
		}
		return null;
	}

	@Override
	public List<Post> getAllPost() {
		return postRepo.findAll();
	}

	@Override
	public Post updatePost(Post post) {
		Post existingPost = postRepo.findById(post.getPID()).get();
		existingPost.setPImg(post.getPImg());
		existingPost.setPDescription(post.getPDescription());
		
		
		Post updatePost = postRepo.save(existingPost);
		return updatePost;
	}

	@Override
	public void deletePost(int id) {
		postRepo.deleteById(id);
		
	}
}
