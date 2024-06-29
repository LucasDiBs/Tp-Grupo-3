package com.unla.grupo03.model;

public class StockProductos {
	
	private int id;
	private Product product;
	private int cantidad;
	private int cantidadCritica;
	
	public StockProductos() {}

	public StockProductos(Product product, int cantidad, int cantidadCritica) {
		this.product = product;
		this.cantidad = cantidad;
		this.cantidadCritica = cantidadCritica;
	}

	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	@Override
	public String toString() {
		return "StockProductos [id=" + id + ", product=" + product + ", cantidad=" + cantidad + ", cantidadCritica="
				+ cantidadCritica + "]";
	}

	
}
