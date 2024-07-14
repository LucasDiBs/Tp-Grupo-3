package com.unla.grupo03.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name = "compra_usuario")
public class Buy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_producto", nullable=false)
	private Product producto;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "importe")
	private double importe;
	
	//para las fechas
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha")
	private LocalDate fecha;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_user", nullable=false)
	private User usuario;

}
