package com.unla.grupo03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.unla.grupo03.model.Lot;
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
	public String mostrarFormularioDeRegistrarLote(Model model) {
		Lot lote = new Lot();
		model.addAttribute("productos",prodRepo.findAll());
		model.addAttribute("lote", lote);
		return "admin/crear_lote";
	}

	@PostMapping("/crear_lote")
	public String guardarLote(@ModelAttribute("lote") Lot lote) {
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
	
	
	/*
    @Autowired
    private LotService lotService;

    @Autowired
    private StockService stockService;

    @Autowired
    private OrderService pedidoService;

    @Autowired
    private UserService usuarioService;

    @GetMapping({"/lotes"})
    private String listarLot(Model model) {
        model.addAttribute("lotes", lotService.listar());
        return "admin/lotes";
    }

    @GetMapping("/crear_lote")
    public String mostrarFormularioDeRegistrarLote(Model model) {
        Lot lote = new Lot();
        model.addAttribute("lote", lote);
        return "admin/crear_lote";
    }

    @PostMapping("/crear_lote")
    public String guardarLote(@ModelAttribute("lote") Lot lote) {
        lote.setStock(stockService.traer(lote.getStock().getId()));
        lote.setPedido(pedidoService.traerPedido(lote.getPedido().getId()));
        lote.setUsuario(usuarioService.traerUserPorId(lote.getUsuario().getId()));
        lotService.crearLote(lote);
        return "redirect:/admin/lotes";
    }

    @GetMapping("/lotes/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable int id, Model model) {
        model.addAttribute("lote", lotService.buscarPorId(id));
        return "admin/editar_lote";
    }

    @PostMapping("/editar/{id}")
    public String actualizarLote(@PathVariable int id, @ModelAttribute("lotes") Lot lote, Model model) {
        Lot loteExistente = lotService.buscarPorId(id);
        loteExistente.setStock(stockService.traer(lote.getStock().getId()));
        loteExistente.setFechaRecepcion(lote.getFechaRecepcion());
        loteExistente.setCantidad(lote.getCantidad());
        loteExistente.setPedido(pedidoService.traerPedido(lote.getPedido().getId()));
        loteExistente.setUsuario(usuarioService.traerUserPorId(lote.getUsuario().getId()));
        
        lotService.actualizar(loteExistente);
        return "redirect:/admin/lotes";
    }

    @GetMapping("/elimina_lotes/{id}")
    public String eliminarLote(@PathVariable int id) {
        lotService.delete(id);
        return "redirect:/admin/lotes";
    }
    */
}