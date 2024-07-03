package com.unla.grupo03.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.unla.grupo03.model.User;
import com.unla.grupo03.model.UserRol;
import com.unla.grupo03.repository.UserRepository;


@Configuration
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;


	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public User createUser(User user) {	

		user.setPassword(passwordEncoder().encode(user.getPassword()));

		UserRol rol = new UserRol(user, "USER");
		user.addRol(rol);

		return userRepo.save(user);
	}	

	@Override
	public boolean checkEmail(String email) {

		return userRepo.existsByEmail(email);
	}

	@Override
	public List<User> listar() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}


	
	@Override
	public User createAdmin(User user) {
		user.setPassword(passwordEncoder().encode(user.getPassword()));

		UserRol rol = new UserRol(user, "ADMIN");
		user.addRol(rol);

		return userRepo.save(user);
	}

	@Override
	public User editarUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public User traerUserPorId(int id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id).get();
	}

	@Override
	public void eliminarUser(int id) {
		userRepo.deleteById(id);
		
	}



}
