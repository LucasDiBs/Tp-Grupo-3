package com.unla.grupo03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.unla.grupo03.model.Product;
import com.unla.grupo03.service.ProductService;

@Controller
@RequestMapping("user/productos")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@ModelAttribute
	@GetMapping({"", "/"})	
	private String listarProduct(Model model) {
		
		model.addAttribute("productos", service.listar());			
		return "productos";
	}
	
	
}