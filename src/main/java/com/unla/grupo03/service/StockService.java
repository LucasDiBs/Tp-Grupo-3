package com.unla.grupo03.service;

import com.unla.grupo03.model.Stock;

public interface StockService {

	public Stock crearStock(Stock stock);
	
	Stock traer(int id);

	Stock editar(Stock s);

}
