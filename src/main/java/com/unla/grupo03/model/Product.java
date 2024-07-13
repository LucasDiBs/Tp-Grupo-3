package com.unla.grupo03.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter 
@Setter
@NoArgsConstructor
@ToString
@Table(name = "producto")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre",nullable=false,length=45)
	private String nombre;

	@Column(name = "descripcion",nullable=false,length=45)
	private String descripcion;

	@Column(name = "precio")
	private double precio;
	
	@Column(name = "precioReposicion")
	private double precioReposicion;
	
	@Column(name = "cantidad")
	private int cantidad;

	@Column(name = "cantidadcritica")
	private int cantidadCritica;
	
	@Column(name = "activo")
	private boolean activo;

	public Product(String nombre, String descripcion, double precio, double precioReposicion, int cantidad,
			int cantidadCritica, boolean activo) {

		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.precioReposicion = precioReposicion;
		this.cantidad = cantidad;
		this.cantidadCritica = cantidadCritica;
		this.activo = activo;
	}
	
	public boolean getActivo() {
		
		return activo;
	}
}
