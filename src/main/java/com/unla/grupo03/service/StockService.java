package com.unla.grupo03.service;

import com.unla.grupo03.model.Stock;

public interface StockService {

	Stock crearStock(Stock stock);
	
	Stock traer(int id);

	Stock editar(Stock s);
	
}
