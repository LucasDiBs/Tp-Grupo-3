package com.unla.grupo03.service;

import java.util.List;

import com.unla.grupo03.model.Product;


public interface ProductService {	
	
	public List<Product> listar();

	public Product crearProducto(Product producto);
	
	public void delete(int id);

	public Product buscarPorId(int id_producto);
	

	
}
