package com.swetank.services.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swetank.entities.Category;
import com.swetank.entities.Post;
import com.swetank.entities.User;
import com.swetank.exception.ResourceNotFoundException;
import com.swetank.payloads.PostDto;
import com.swetank.repositories.CategoryRepo;
import com.swetank.repositories.PostRepo;
import com.swetank.repositories.UserRepo;
import com.swetank.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId) {
		
		User user = this.userRepo.findById(userId)
				                 .orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));
		
		Category category = this.categoryRepo.findById(categoryId)
                                             .orElseThrow(() -> new ResourceNotFoundException("Category","Id",categoryId));
		
	   Post post = this.modelMapper.map(postDto, Post.class);
	   post.setImageName("default.png");
	   post.setAddedDate(new Date());
	   post.setUser(user);
	   post.setCategory(category);
	   
	   Post createPost = this.postRepo.save(post);
	   return this.modelMapper.map(createPost, PostDto.class);
	
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		

	}

	@Override
	public PostDto getPostById(Integer postId) {
		
		return null;
	}

	@Override
	public List<PostDto> getAllPost() {
		
		return null;
	}

	@Override
	public List<PostDto> getAllPostsByUser(Integer userId) {
		
		return null;
	}

	@Override
	public List<PostDto> getAllPostsByCategory(Integer categoryId) {
		
		return null;
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		
		return null;
	}

}
