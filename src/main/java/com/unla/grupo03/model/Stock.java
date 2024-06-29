package com.unla.grupo03.model;

import java.util.List;

public class Stock {

	private int id;
	private List<StockProductos> stock;

	public Stock() {}

	public Stock(List<StockProductos> stock) {
		
		this.stock = stock; 
	}
	
	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public List<StockProductos> getStock() {
		return stock;
	}

	public void setStock(List<StockProductos> stock) {
		this.stock = stock;
	}

	
}
