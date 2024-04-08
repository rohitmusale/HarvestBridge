package com.harvestBridge.service;

import java.util.List;

import com.harvestBridge.entity.Post;

public interface PostService {
	Post createPost(Post post);
	Post getPostById(int id);
	List<Post> getAllPost();
	Post updatePost(Post post);
	void deletePost(int id);
}
