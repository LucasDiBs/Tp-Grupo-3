package com.unla.grupo03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.unla.grupo03.model.Lot;
import com.unla.grupo03.model.Product;
import com.unla.grupo03.repository.ProductRepository;
import com.unla.grupo03.service.LotService;
import com.unla.grupo03.service.OrderService;
import com.unla.grupo03.service.ProductService;
import com.unla.grupo03.service.StockService;
import com.unla.grupo03.service.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/")
public class LotController {
	
	@Autowired
	private LotService service;
	
	@Autowired
	private ProductRepository prodRepo;
	
	@GetMapping({"/lotes"})	
	private String listarLot(Model model) {
		model.addAttribute("lotes", service.listar());			
		return "admin/lotes";
	}

	@GetMapping("/crear_lote")
	public String mostrarFormularioDeRegistrarLote(Model model, Model modelo) {
		Lot lote = new Lot();
		model.addAttribute("productos",prodRepo.findAll());
		
		model.addAttribute("lote", lote);
		
		return "admin/crear_lote";
	}

	@PostMapping("/crear_lote")
	public String guardarLote(@ModelAttribute("lote") Lot lote) {	
	
		lote.getProducto().setCantidad(lote.getCantidad() +lote.getProducto().getCantidad());
		service.crearLote(lote);
		return "redirect:/admin/lotes";
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
		loteExistente.getProducto().setCantidad(loteExistente.getCantidad() +loteExistente.getProducto().getCantidad());
		loteExistente.setPedido(lote.getPedido());
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