package com.unla.grupo03.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.unla.grupo03.model.User;
import com.unla.grupo03.repository.UserRepository;
import com.unla.grupo03.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
		
	@Autowired
	private UserService service;
	
	@ModelAttribute
	private void userDetalles(Model m, Principal p) {
		String email = p.getName();
		User user = userRepo.findByEmail(email);
		m.addAttribute("user", user);
	}

	
	@GetMapping("/clients")	
	private String listarClientes(Model model) {		
		model.addAttribute("clientes",service.listar());			
		return "user/clients";
	}
	
	@GetMapping("/")
	public String home() {
		
		return "user/home";
	}
}
