package com.unla.grupo03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.unla.grupo03.model.Product;
import com.unla.grupo03.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepo;
	
	
	@Override
	public List<Product> listar() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		productRepo.deleteById(id);
		
	}


	@Override
	public Product crearProducto(Product producto) {
		// TODO Auto-generated method stub
		return productRepo.save(producto);
	}


	@Override
	public Product buscarPorId(int id_producto) {
		// TODO Auto-generated method stub
		return productRepo.findById(id_producto).get();
	}
	
}
