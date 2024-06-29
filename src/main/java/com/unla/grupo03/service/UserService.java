package com.unla.grupo03.service;

import java.util.List;


import com.unla.grupo03.model.User;

public interface UserService {
	
	public User createUser(User user);
	
	public List<User> listar();
	
	public boolean checkEmail(String email);
	
	public User createAdmin(User user);

}
