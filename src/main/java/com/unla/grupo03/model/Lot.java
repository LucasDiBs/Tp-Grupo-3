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
@Table(name = "lote")
public class Lot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
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
}
