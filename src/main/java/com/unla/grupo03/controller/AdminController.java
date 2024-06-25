package com.unla.grupo03.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.grupo03.model.Product;
import com.unla.grupo03.model.User;
import com.unla.grupo03.repository.UserRepository;
import com.unla.grupo03.service.ProductService;
import com.unla.grupo03.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserService uService;
	
	
	@Autowired
	private ProductService service;
	
	@ModelAttribute
	private void userDetalles(Model m, Principal p) {

		String email = p.getName();
		User user = userRepo.findByEmail(email);
		m.addAttribute("admin", user);
	}

	@GetMapping("/admins")	
	private String listarClientesAdmins(Model model) {		
		model.addAttribute("administradores",uService.listar());			
		return "admin/admins";
	}
	
	@GetMapping("/clients")	
	private String listarClientes(Model model) {		
		model.addAttribute("clientes",uService.listar());			
		return "admin/clients";
	}
	
	@GetMapping("/productos")	
	private String listarProductos(Model model) {		
		model.addAttribute("productos",service.listar());			
		return "admin/productos";
	}
	

	@GetMapping("/")
	public String home() {
		
		return "admin/home";
	}	
	

	@GetMapping("/registro")
	public String registroFrom(Model modelo) {		
		User user = new User();
		modelo.addAttribute("user", user);		
		return "admin/registro"; 
	}	

	@PostMapping("/registro")
	public String createAdmin(@ModelAttribute User user, HttpSession session) {
		
		boolean check = uService.checkEmail(user.getEmail()) ;
		
		if(check) 			
			session.setAttribute("msg", "Ya existe el email");			
		else {
			
			User userAux = uService.createAdmin(user);
			
			if(userAux != null)
				session.setAttribute("msg", "Registro exitoso");
			else
				session.setAttribute("msg", "Algo salio mal");	
		}	
		
			return "/admin/registro";
	}
	
	
	@GetMapping("/nuevoProducto")
	public String mostarProductoForm(Model modelo) {		
		Product producto = new Product();
		
		modelo.addAttribute("producto", producto); 
		
		return "admin/nuevoProducto"; 
	}
	
	
	
	@PostMapping("/nuevoProducto")
	public String crearProducto(@ModelAttribute("producto") Product producto, HttpSession session) {		
		
		Product pAux  = service.crearProducto(producto);		
		
		if(pAux != null)
			session.setAttribute("msg", "Registro exitoso");
		else
			session.setAttribute("msg", "Algo salio mal");	
		
		
		return "/admin/nuevoProducto"; 
	}
	

}
