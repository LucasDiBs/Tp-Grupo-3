package com.unla.grupo03.model;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
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
import lombok.ToString;

@Entity
@Getter @Setter 
@NoArgsConstructor
@ToString
@Table(name = "compra")
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechaCompra")
	private LocalDate fechaCompra;
	
	@Column(name = "cantidadCompra")
	private int cantidadCompra;
	
	@Column(name = "importe")
	private double importe;
	
	@Column(name = "importeUnidad")
	private double importeUnidad;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idProducto",nullable=false)
	private Product producto;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idUsuario",nullable=false)
	private User usuario;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public int getCantidadCompra() {
		return cantidadCompra;
	}

	public void setCantidadCompra(int cantidadCompra) {
		this.cantidadCompra = cantidadCompra;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public double getImporteUnidad() {
		return importeUnidad;
	}

	public void setImporteUnidad(double importeUnidad) {
		this.importeUnidad = importeUnidad;
	}

	public Product getProducto() {
		return producto;
	}

	public void setProducto(Product producto) {
		this.producto = producto;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	
	
}
