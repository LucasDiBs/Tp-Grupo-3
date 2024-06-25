package com.unla.grupo03.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "stock")
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "cantidadActual")
	private int cantidadActual;
	
	@Column(name = "cantidadCritica")
	private int cantidadCritica;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idProducto",nullable=false)
	private Product producto;

	public Stock(int id, int cantidadActual, int cantidadCritica, Product producto) {
		super();
		this.id = id;
		this.cantidadActual = cantidadActual;
		this.cantidadCritica = cantidadCritica;
		this.producto = producto;
	}
	
	
	
}
