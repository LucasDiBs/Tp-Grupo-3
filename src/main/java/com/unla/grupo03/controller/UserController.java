package com.unla.grupo03.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.unla.grupo03.model.Order;
import com.unla.grupo03.model.Product;
import com.unla.grupo03.model.User;
import com.unla.grupo03.modelDTO.ProductDTO;
import com.unla.grupo03.repository.UserRepository;
import com.unla.grupo03.service.ProductService;
import com.unla.grupo03.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
		
	@Autowired
	private UserService service;
	
	@Autowired
	private ProductService productService;
	
	@ModelAttribute
	private void userDetalles(Model m, Principal p) {
		String email = p.getName();
		User user = userRepo.findByEmail(email);
		m.addAttribute("user", user);
	}
	
	@GetMapping("/")
	public String home() {
		
		return "user/home";
	}
	
	@GetMapping("/usuario/{id}")
	private String traerUsuarioPorId(@PathVariable int id, Model m) {				
		m.addAttribute("user", service.traerUserPorId(id));
		return "user/usuario";
	}
	
	
	@GetMapping("/editarUsuario/{id}")
	public String formularioDeEdicionUser(@PathVariable int id, Model modelo) {		
		modelo.addAttribute("user", service.traerUserPorId(id));
		return "/user/editarUsuario";
	}

	
	
	@PostMapping("/editarUsuario/{id}")
	public String actualizarUser(@PathVariable int id, @ModelAttribute("user") User user, Model modelo) {
		User auxUser = service.traerUserPorId(id);
		
		auxUser.setId(id);
		auxUser.setNombre(user.getNombre());
		auxUser.setApellido(user.getApellido());
		auxUser.setEmail(user.getEmail());		
		service.editarUser(auxUser);
		return "/user/home";
	}
	
	
	@GetMapping("/eliminarUsuario/{id}")
	public String eliminarUsuario(@PathVariable int id, Model modelo) {		
	
		service.eliminarUser(id);
		return "redirect: /logout";
	}

	//////////////////////////////
	@GetMapping("/mostrarProductos")
	public String listarProductosParaComprar(Model modelo) {
		
		System.out.println("Lista de productos a vender");
		
		modelo.addAttribute("listaDto", productService.listarDto());
		
		return "user/mostrarProductos";
	}
	//////////////////////////////
	@GetMapping("/comprar/{id}")
	public String comprarProducto(@PathVariable int id) {
		
		System.out.println(productService.buscarPorId(id));
		
		return "user/comprar";
	}
	
	////////////////////////////

}
