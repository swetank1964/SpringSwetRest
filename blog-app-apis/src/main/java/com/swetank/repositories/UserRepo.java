package com.swetank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swetank.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
