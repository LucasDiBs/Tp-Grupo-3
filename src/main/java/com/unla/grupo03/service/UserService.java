package com.unla.grupo03.service;

import java.util.List;
import java.util.Optional;



import com.unla.grupo03.model.User;

public interface UserService {
	
	public User createUser(User user);
	
	public List<User> listar();
	
	public boolean checkEmail(String email);
	
	public User createAdmin(User user);

	public User editarUser(User user);
	
	public User traerUserPorId(int id);
	
	public void eliminarUser(int id);
	
	public User traerUserPorEmail(String email);
}
