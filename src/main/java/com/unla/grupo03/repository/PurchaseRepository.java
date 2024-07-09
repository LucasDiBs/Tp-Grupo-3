package com.unla.grupo03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.grupo03.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{

}
