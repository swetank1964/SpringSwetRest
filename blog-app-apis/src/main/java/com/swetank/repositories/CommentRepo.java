package com.swetank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swetank.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment,Integer>{

}
