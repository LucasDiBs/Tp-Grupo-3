package com.unla.grupo03.model;

import java.time.LocalDate;

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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_producto", nullable=false)
	private Product producto;

	@Column(name = "cantidadPedida")
	private int cantidadPedida;	
	
	@Column(name = "fecha")
	private LocalDate fecha;
	
	@Column(name = "proveedor",nullable=false, length=45)
	private String proveedor;

	@Override
	public String toString() {
		return "Order [id=" + id + ", producto=" + producto + ", cantidadPedida=" + cantidadPedida + ", fecha=" + fecha
				+ ", proveedor=" + proveedor + "]";
	}
		
	
}
