package com.sid.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sid.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findUserByUsername(String username);
}
