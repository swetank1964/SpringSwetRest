package com.swetank.services;

import java.util.List;

import com.swetank.payloads.PostDto;

public interface PostService {

	
	//create
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//update
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//get
	PostDto getPostById(Integer postId);
	
	//get All
	List<PostDto> getAllPost();
	
	//get All By User
	List<PostDto> getAllPostsByUser(Integer userId);
	
	//get All By Category
	List<PostDto> getAllPostsByCategory(Integer categoryId);
	
	//search posts
	List<PostDto> searchPosts(String keyword);
}
