package com.unla.grupo03.model;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "compra")
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@CreationTimestamp
	@Column(name = "fechaCompra")
	private LocalDate fechaCompra;
	
	@Column(name = "cantidadCompra")
	private int cantidadCompra;
	
	@Column(name = "importe")
	private double importe;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idProducto",nullable=false)
	private Product producto;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUsuario",nullable=false)
	private User usuario;
}
