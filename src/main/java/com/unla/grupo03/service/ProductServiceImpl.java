package com.unla.grupo03.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo03.model.Product;
import com.unla.grupo03.modelDTO.ProductDTO;
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

	@Override
	public List<ProductDTO> listarDto() {
		// TODO Auto-generated method stub
		List<ProductDTO> listaDto = new ArrayList<ProductDTO>();
		
		for(Product producto: productRepo.findAll()) {
			
			ProductDTO prodDto = new ProductDTO();
			
			prodDto.setId(producto.getId());
			prodDto.setNombre(producto.getNombre());
			prodDto.setDescripcion(producto.getDescripcion());
			prodDto.setPrecio(producto.getPrecio());
			
			listaDto.add(prodDto);	
		}			
			
		return listaDto;
	}
	
}
