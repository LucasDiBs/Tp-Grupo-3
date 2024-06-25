package com.unla.grupo03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.unla.grupo03.model.Stock;
import com.unla.grupo03.repository.StockRepository;

@Configuration
@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepo;

	@Override
	public List<Stock> listar() {
		// TODO Auto-generated method stub
		return stockRepo.findAll();
	}

}
