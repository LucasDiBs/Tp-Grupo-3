package com.unla.grupo03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.grupo03.model.Lot;
import com.unla.grupo03.service.LotService;

@Controller
@RequestMapping("/admin/")
public class LotController {
	
	@Autowired
	private LotService service;
	
	@GetMapping({"/lotes"})	
	private String listarLot(Model model) {
		model.addAttribute("lotes", service.listar());			
		return "admin/lotes";
	}

	@GetMapping("/crear_lote")
	public String mostrarFormularioDeRegistrarLote(Model model) {
		Lot lote = new Lot();
		model.addAttribute("lote", lote);
		return "admin/crear_lote";
	}
	
	@PostMapping("/crear_lote")
	public String guardarLote(Model model, Lot lote) {
		service.crearLote(lote);
		return "/lotes";
	}
	
//	@GetMapping("/lotes/editar/{id}")
//	public String mostrarFormularioDeEditar(@PathVariable int id, Model model) {
//		model.addAttribute("lotes", service.buscarPorId(id));
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
//	@PostMapping("/lotes/{id}")
//	public String eliminarEstudiante(@PathVariable int id) {
//		service.delete(id);
//		return "redirect:/lotes";
//	}
}
