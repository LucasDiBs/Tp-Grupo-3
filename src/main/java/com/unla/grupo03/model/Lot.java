package com.unla.grupo03.model;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter 
@Setter
@NoArgsConstructor
@Table(name="lote", uniqueConstraints=@UniqueConstraint(columnNames= {"id", "user_id"}))
public class Lot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinColumn(name="stock_id", nullable=false)
	private Stock stock;
	
	@CreationTimestamp
	@Column(name = "fechaRecepcion")
	private LocalDate fechaRecepcion;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idPedido",nullable=false)
	private Order pedido;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser",nullable=false)
	private User usuario;

	public Lot(Stock stock, LocalDate fechaRecepcion, int cantidad, Order pedido, User usuario) {
		super();
		this.stock = stock;
		this.fechaRecepcion = LocalDate.now();
		this.cantidad = cantidad;
		this.pedido = pedido;
		this.usuario = usuario;
	}
	
	
	
}
