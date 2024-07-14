package com.unla.grupo03.controller;

import java.security.Principal;
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

import com.unla.grupo03.model.Order;
import com.unla.grupo03.model.Product;
import com.unla.grupo03.model.User;
import com.unla.grupo03.repository.UserRepository;
import com.unla.grupo03.service.OrderService;
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
	
	@Autowired
	private OrderService orderService;
	
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
	
	@GetMapping("/usuario/{id}")
	private String traerUsuarioPorId(@PathVariable int id, Model m) {				
		m.addAttribute("user", uService.traerUserPorId(id));
		return "admin/usuario";
	}

	
	
	@PostMapping("/usuario/{id}")
	public String actualizarUser(@PathVariable int id, @ModelAttribute("user") User user, Model modelo) {
		User auxUser = uService.traerUserPorId(id);
		
		auxUser.setId(id);
		auxUser.setNombre(user.getNombre());
		auxUser.setApellido(user.getApellido());
		auxUser.setEmail(user.getEmail());		
		uService.editarUser(auxUser);
		return "admin/clients";
	}
	
	
	@GetMapping("/eliminarUsuario/{id}")
	public String eliminarUsuario(@PathVariable int id, Model modelo) {		
	
		uService.eliminarUser(id);
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
		
		producto.setActivo(true);		
		
		Product pAux  = service.crearProducto(producto);		
		
		if(pAux != null)
			session.setAttribute("msg", "Registro exitoso");
		else
			session.setAttribute("msg", "Algo salio mal");			
		
		return "/admin/nuevoProducto"; 
	}
	
	//para registrar un pedido de productos
	@GetMapping("/nuevoPedido")
	public String mostrarPedidoForm(Model modelo) {
		
		Order pedido = new Order();
		int id_producto = 0;
		
		modelo.addAttribute("pedido", pedido);
		modelo.addAttribute("id_producto", id_producto);
		
		return "admin/nuevoPedido";		
	}
	
	@PostMapping("/nuevoPedido")
	public String crearPedido(@ModelAttribute("pedido") Order pedido, @ModelAttribute("id_producto") Integer id_producto, HttpSession session) {
		
		//buscar el producto con el id = id_producto
		Product product = service.buscarPorId(id_producto);
		
		pedido.setProducto(product);
		pedido.setFecha(LocalDate.now());
		pedido.setEstado("Procesando");
		
		pedido.setCostoPedido(pedido.getCantidadPedida() * product.getPrecioReposicion());

		//enviar al servicio que lo escriba en la bd		
		Order pedidoAux = orderService.crearPedido(pedido);		
		
		if(pedidoAux != null)
			session.setAttribute("msg", "Se almaceno el pedido");
		else
			session.setAttribute("msg", "Algo salio mal");		
		
		return "admin/nuevoPedido";
	}
	
	//////////////////////////////
	//metodo para listar los pedidos (clase Order)
	@GetMapping("/listarPedidos")
	public String listarPedidos(Model modelo) {
		
		List<Order> pedidos = orderService.listarPedidos();
		modelo.addAttribute("pedidos", pedidos);		
		
		return "admin/listarPedidos";
	}

	//metodos para modificar un pedido: proveedor, estado, etc.
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model modelo) {
		
		Order pedido = orderService.traerPedido(id);
		int idProducto = pedido.getProducto().getId();
		
		modelo.addAttribute("pedido", pedido);
		modelo.addAttribute("idProducto", idProducto);
		
		return "admin/formEditarPedido";
	}
	
	
	
	
	@PostMapping("/editar")
	public String actualizarPedido(@ModelAttribute("pedido") Order pedido, @ModelAttribute("idProducto") Integer idProducto, HttpSession session) {
		
		Product producto = service.buscarPorId(idProducto);
		pedido.setProducto(producto);
	
		//enviar a la bd para actualizar
		Order pedidoAux = orderService.crearPedido(pedido);
		
		if(pedidoAux != null)
			session.setAttribute("msg", "Registro exitoso");
		else
			session.setAttribute("msg", "Algo salio mal");		
		
		return "redirect:/admin/listarPedidos";
	}
	
	
	
	
	//metoods para borrar un pedido de la bd
	@GetMapping("/eliminar/{id}")
	public String borrarPedido(@PathVariable int id) {
		
		orderService.eliminarPedido(id);
		
		return "redirect:/admin/listarPedidos";
	}	

	//para redireccionar
	@GetMapping("/atras")
	public String redireccionAdminHome() {
		
		return "redirect:/admin/";
	}	

		
}
