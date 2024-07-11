package com.unla.grupo03.service;

import java.util.List;

import com.unla.grupo03.model.Purchase;

public interface PurchaseService {
	
	public Purchase crearCompraUsuario(Purchase compra);
	
	public Purchase traerCompraUsuario(int idCompra);
	
	public List<Purchase> traerComprasUsuario(int idUsuario);

}
