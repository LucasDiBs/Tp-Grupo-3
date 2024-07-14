package com.unla.grupo03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo03.model.Purchase;
import com.unla.grupo03.repository.PurchaseRepository;

@Service
public class PurchaseServiceImpl implements PurchaseService{

	@Autowired
	private PurchaseRepository purchaseReposit;
	
	@Override
	public Purchase crearCompraUsuario(Purchase compra) {
		// TODO Auto-generated method stub
		return purchaseReposit.save(compra);
	}

	@Override
	public Purchase traerCompraUsuario(int idCompra) {
		// TODO Auto-generated method stub
		return purchaseReposit.findById(idCompra).get();
	}

	@Override
	public List<Purchase> traerComprasUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return purchaseReposit.traerComprasUsuario(idUsuario);
	}

}
