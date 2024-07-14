package com.unla.grupo03.service;

import java.util.List;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.beans.factory.annotation.Autowired;

import com.unla.grupo03.model.Stock;
import com.unla.grupo03.repository.StockRepository;

public class StockServiceImpl implements StockService{
	
	@Autowired
	private StockRepository stockRepo;

	@Override
	public Stock crearStock(Stock s) {
		return stockRepo.save(s);
	}

	@Override
	public Stock traer(int id) {
		return stockRepo.findById(id).get();
	}

	@Override
	public Stock editar(Stock s) {
		return stockRepo.save(s);
	}
	
}

