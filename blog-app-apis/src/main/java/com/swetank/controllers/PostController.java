package com.swetank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swetank.payloads.PostDto;
import com.swetank.services.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;

	//create
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(
			@Valid @RequestBody PostDto postDto,
			@PathVariable Integer userId,
			@PathVariable Integer categoryId){
		
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
		
	}
	
	//create
	
	
	//update
	
	
	//delete
	
	
	//get
	
	//get All
	
	
	//get By User
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
		List<PostDto> postsByUser = this.postService.getAllPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(postsByUser,HttpStatus.OK);
	}
	
	//get By Category
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
		List<PostDto> postsByCategory = this.postService.getAllPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(postsByCategory,HttpStatus.OK);
	}
	
}
