package com.unla.grupo03.service;

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

}
