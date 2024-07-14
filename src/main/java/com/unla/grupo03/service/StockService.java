package com.unla.grupo03.service;

import com.unla.grupo03.model.Stock;

public interface StockService {

	public Stock crearStock(Stock stock);
	
	public Stock traer(int id);
	
	public Stock editar(Stock s);
}
