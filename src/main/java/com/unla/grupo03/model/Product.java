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


	public Product(String nombre, String descripcion, double precio, double precioReposicion, int cantidad, int cantidadCritica, boolean activo) {
		super();

		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.precioReposicion = precioReposicion;
		this.cantidad = cantidad;
		this.cantidadCritica = cantidadCritica;
		this.activo = activo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public double getPrecioReposicion() {
		return precioReposicion;
	}


	public void setPrecioReposicion(double precioReposicion) {
		this.precioReposicion = precioReposicion;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public int getCantidadCritica() {
		return cantidadCritica;
	}


	public void setCantidadCritica(int cantidadCritica) {
		this.cantidadCritica = cantidadCritica;
	}
	
	public boolean getActivo() {
		
		return activo;
	}


	public void setActivo(boolean b) {
		this.activo = b;
	}
}
