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

import com.harvestBridge.entity.Post;
import com.harvestBridge.service.PostService;

import jakarta.validation.Valid;

@RestController
public class PostController {
	@Autowired
	PostService postService;
	
	@PostMapping("/post")
	public Post savePost(@Valid @RequestBody Post post) {
		return postService.createPost(post);
	}
	
	@GetMapping("/post/{id}")
	public Post getPostById(@PathVariable("id")int id) {
		return postService.getPostById(id);
	}
	
	@GetMapping("post/getAllData")
	public List<Post> getAllPost(){
		List<Post> post = postService.getAllPost();
		return post;
	}
	
	@PutMapping("/post/update/{id}")
	public Post updatePost(@PathVariable("id") int id, @RequestBody Post post) {
		post.setPID(id);
		Post updatePost = postService.updatePost(post);
		return updatePost;
	}
	
	@DeleteMapping("/post/delete/{id}")
	public void deletePost(@PathVariable int id) {
		postService.deletePost(id);
		System.out.println("Delete from post table Successfully");
	}
}
