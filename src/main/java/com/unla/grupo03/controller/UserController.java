package com.unla.grupo03.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.unla.grupo03.model.Buy;
import com.unla.grupo03.model.Order;
import com.unla.grupo03.model.Product;
import com.unla.grupo03.model.Purchase;
import com.unla.grupo03.model.User;
import com.unla.grupo03.modelDTO.ProductDTO;
import com.unla.grupo03.repository.UserRepository;
import com.unla.grupo03.service.ProductService;
import com.unla.grupo03.service.PurchaseService;
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
	
	@Autowired
	private PurchaseService purchaseService;
	
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
		
		modelo.addAttribute("listaDto", productService.listar());		

		return "user/mostrarProductos";
	}
	//////////////////////////////
	//cargo los datos para la compra por parte del usuario
	@GetMapping("/comprar/{id}")
	public String comprarProducto(@PathVariable int id, Model modelo) {

		modelo.addAttribute("producto", productService.buscarPorId(id));	
		modelo.addAttribute("cantidadSolicitada", 0);		

		return "/user/comprar";
	}
	
	////////////////////////////
	//para mostrar el ticket de compra
	//en este metodo, se deberia hacer: buscar el producto y disminuir la cantidad, crear el objeto Compra y guardarlo en la BD
	@GetMapping("/ticket/{id}")
	public String ticketDeCompra(@PathVariable int id, @ModelAttribute ("cantidadSolicitada") Integer cantidadSolicitada, Model modelo) {
		
		User usuario = (User) modelo.getAttribute("user");
		Product producto = productService.buscarPorId(id);		
		
		//crea la compra
		Purchase compraUsuario = new Purchase();
		
		compraUsuario.setProducto(producto);
		compraUsuario.setUsuario(usuario);
		compraUsuario.setCantidadCompra(cantidadSolicitada);
		compraUsuario.setFechaCompra(LocalDate.now());
		compraUsuario.setImporte(cantidadSolicitada * producto.getPrecio());
		
		//estos datos los muestra en la vista
		modelo.addAttribute("producto", producto);
		modelo.addAttribute("importeTotal",compraUsuario.getImporte());
		modelo.addAttribute("fechaActual", LocalDate.now());
		
		//actualizo la catidad del producto en la bd
		producto.setCantidad(producto.getCantidad() - cantidadSolicitada);
		productService.crearProducto(producto);
		
		
		//envia la compra a la bd si esta no existe
		if(purchaseService.traerCompraUsuario(compraUsuario.getId()) == null) {
			purchaseService.crearCompraUsuario(compraUsuario);
		}		
		
		return "/user/ticket";
	}	
	
	//para redireccionar
	@GetMapping("/atras")
	public String redireccionUserHome() {
		
		return "redirect:/user/";
	}	
}
