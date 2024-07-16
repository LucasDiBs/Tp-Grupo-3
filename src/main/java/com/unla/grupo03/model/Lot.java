package com.unla.grupo03.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.unla.grupo03.service.StockService;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.Constraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter 
@Setter
@NoArgsConstructor

public class Lot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	
	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaEntrega;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="stock_id", nullable=false)
	private Stock stock;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//@CreationTimestamp

	@Column(name = "fechaRecepcion")
	private LocalDate fechaRecepcion;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "proveedor")
	private String proveedor;
	
	@Column(name = "precioCompra")
	private double precioCompra;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idProducto",nullable=false)
	private Product producto;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idPedido",nullable=false)
	private Order pedido;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser",nullable=false)
	private User usuario;


	public Lot(int cantidad, String proveedor, double precioCompra, Product producto) {
		super();
		this.cantidad = cantidad;
		this.proveedor = proveedor;
		this.precioCompra = precioCompra;
		this.producto = producto;
		
	}	
	
}
