package com.swetank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swetank.entities.Category;
import com.swetank.entities.Post;
import com.swetank.entities.User;

public interface PostRepo extends JpaRepository<Post,Integer>{
	
	List<Post> findByCategory(Category category);

	List<Post> findByUser(User user);
	
	List<Post> findByTitleContaining(String title);
}
