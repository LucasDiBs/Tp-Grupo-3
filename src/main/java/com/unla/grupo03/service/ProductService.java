package com.unla.grupo03.service;

import java.util.List;

import com.unla.grupo03.model.Product;

import com.unla.grupo03.modelDTO.ProductDTO;


public interface ProductService {	
	
	public List<Product> listar();

	public Product crearProducto(Product producto);
	
	public void delete(int id);

	public Product buscarPorId(int id_producto);
	

	public List<ProductDTO> listarDto();

	
}
