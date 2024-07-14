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
@Table(name = "pedido")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_producto", nullable=false)
	private Product producto;

	@Column(name = "cantidadPedida")
	private int cantidadPedida;	
	
	//para las fechas
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha")
	private LocalDate fecha;
	
	@Column(name = "proveedor",nullable=false, length=45)
	private String proveedor;
	
	@Column(name = "estado", length=15)
	private String estado;

	@Column(name = "costoPedido")
	private double costoPedido;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProducto() {
		return producto;
	}

	public void setProducto(Product producto) {
		this.producto = producto;
	}

	public int getCantidadPedida() {
		return cantidadPedida;
	}

	public void setCantidadPedida(int cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getCostoPedido() {
		return costoPedido;
	}

	public void setCostoPedido(double costoPedido) {
		this.costoPedido = costoPedido;
	}

		
}
