package com.unla.grupo03.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.*;


import com.unla.grupo03.model.Lot;
import com.unla.grupo03.model.Product;
import com.unla.grupo03.model.Purchase;
import com.unla.grupo03.model.Stock;
import com.unla.grupo03.model.User;
import com.unla.grupo03.repository.LotRepository;
import com.unla.grupo03.repository.ProductRepository;
import com.unla.grupo03.service.LotService;

import com.unla.grupo03.service.ProductService;
import com.unla.grupo03.service.ProductServiceImpl;
import com.unla.grupo03.service.StockService;
import com.unla.grupo03.service.StockServiceImpl;

import com.unla.grupo03.service.OrderService;
import com.unla.grupo03.service.StockService;
import com.unla.grupo03.service.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/")
public class LotController {
	
	@Autowired
	private LotService service;
	
	@Autowired
	private LotRepository repo;
	
	
	@Autowired
	private ProductRepository pRepo;
	
	/*@Autowired
	private StockServiceImpl sService;
	*/
	@GetMapping({"/lotes"})	
	private String listarLot(Model model) {
		model.addAttribute("lotes", service.listar());			
		return "admin/lotes";
	}

	@GetMapping("/crear_lote")
	public String mostrarFormularioDeRegistrarLote(Model modelo) {
		List<Product> productos = pRepo.findAll();	
		
		Lot lote  = new Lot();		
		modelo.addAttribute("lote", lote); 	
		
		modelo.addAttribute("productos", productos); 		
		
		return "/admin/crear_lote";
	}


	@PostMapping("/crear_lote")
	public String guardarLote(Lot lote, Model modelo) {
		
	
		service.crearLote(lote);
		return "redirect:/admin/lotes";
	}
	

	

	
	
	
	
//	@GetMapping("/lotes/editar/{id}")
//	public String mostrarFormularioDeEditar(@PathVariable int id, Model model) {
//		model.addAttribute("lote", service.buscarPorId(id));
//		return "editar_lote";
//	}
//	
//	@PostMapping("/lotes/{id}")
//	public String actualizarLote(@PathVariable int id, @ModelAttribute("lotes") Lot lote, Model model) {
//		Lot loteExistente = service.buscarPorId(id);
//		loteExistente.setStock(lote.getStock());;
//		loteExistente.setFechaRecepcion(lote.getFechaRecepcion());
//		loteExistente.setCantidad(lote.getCantidad());
//		loteExistente.setPedido(lote.getPedido());
//		loteExistente.setUsuario(lote.getUsuario());
//		
//		service.actualizar(loteExistente);
//		return "redirect:/lotes";
//	}
//	

	
	@GetMapping("/eliminarLote/{id}")
	 public String eliminarProducto(@PathVariable int id){
		
			 service.delete(id);	 
		 
		 return"redirect:/admin/lotes";
	 }


	
	

	@GetMapping("/editar_lote/{id}")
	public String mostrarFormularioDeEditar(@PathVariable int id, Model model) {
		model.addAttribute("lote", service.buscarPorId(id));
		return "admin/editar_lote";
	}
	
	@PostMapping("/editar_lote/{id}")
	public String actualizarLote(@PathVariable int id, @ModelAttribute("lotes") Lot lote, Model model) {
		Lot loteExistente = service.buscarPorId(id);
		loteExistente.setStock(lote.getStock());;
		loteExistente.setFechaRecepcion(lote.getFechaRecepcion());
		loteExistente.setCantidad(lote.getCantidad());
		loteExistente.setUsuario(lote.getUsuario());
		
		service.actualizar(loteExistente);
		return "redirect:/admin/lotes";
	}
	
	@GetMapping("/elimina_lote/{id}")
	public String eliminarLote(@PathVariable int id) {
		service.delete(id);
		return "redirect:/admin/lotes";
	}
	
	
}
