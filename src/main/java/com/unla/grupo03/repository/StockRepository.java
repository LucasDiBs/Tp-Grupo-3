package com.unla.grupo03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.grupo03.model.Stock;

public interface StockRepository  extends JpaRepository<Stock, Integer>{

}
