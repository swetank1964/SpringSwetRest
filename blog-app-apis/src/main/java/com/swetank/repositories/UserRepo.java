package com.swetank.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swetank.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{

	Optional<User> findByEmail(String email);
}
