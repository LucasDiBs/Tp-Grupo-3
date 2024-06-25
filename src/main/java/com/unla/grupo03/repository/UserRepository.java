package com.unla.grupo03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.grupo03.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	public boolean existsByEmail(String email);
	
	public User findByEmail(String email);

}
