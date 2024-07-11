package com.unla.grupo03.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.grupo03.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{
	
	//trae las compras del usuario con el id pasado como parametro
	@Query("SELECT p FROM Purchase p JOIN FETCH p.usuario u WHERE u.id = (:id)")
	public List<Purchase> traertraerComprasUsuario(int id);
}
