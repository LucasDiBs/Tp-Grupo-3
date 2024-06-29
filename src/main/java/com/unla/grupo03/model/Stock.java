package com.unla.grupo03.model;

import java.util.List;

public class Stock {

	private List<StockProductos> stock;

	public Stock() {}

	public Stock(List<StockProductos> stock) {
		
		this.stock = stock; 
	}

	public List<StockProductos> getStock() {
		return stock;
	}

	public void setStock(List<StockProductos> stock) {
		this.stock = stock;
	}

	
}
