package com.unla.grupo03.modelDTO;

import java.util.ArrayList;
import java.util.List;

import com.unla.grupo03.model.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
public class ProductDTO {
	
	private int id;
	
	private String nombre;
	
	private String descripcion;
	
	private double precio;
	
	private double cantidad;
	private boolean activo;
	
	public List<ProductDTO> convertirADto(List<Product> listaProductos){
		
		List<ProductDTO> listaDto = new ArrayList<ProductDTO>();
		
		for(Product p: listaProductos) {
			
			ProductDTO prodDto = new ProductDTO();
			
			prodDto.setId(p.getId());
			prodDto.setNombre(p.getNombre());
			prodDto.setDescripcion(p.getDescripcion());
			prodDto.setPrecio(p.getPrecio());
			prodDto.setCantidad(p.getCantidad());
			prodDto.setActivo(p.getActivo());
			
			listaDto.add(prodDto);	
		}	
		
		return listaDto;
	}
	

}
