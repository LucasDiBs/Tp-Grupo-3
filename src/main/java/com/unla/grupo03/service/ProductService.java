package com.unla.grupo03.service;

import java.util.List;
import java.util.Optional;

import com.unla.grupo03.model.Product;

public interface ProductService {	
	
	public List<Product> listar();

	public Product crearProducto(Product producto);
	
	public void delete(int id);

	public Optional<Product> buscarPorId(Integer id_producto);
	
}
