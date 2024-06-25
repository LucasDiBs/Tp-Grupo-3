package com.unla.grupo03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.unla.grupo03.model.AlertaFaltantes;

public interface AlertaFaltantesRepository extends CrudRepository<AlertaFaltantes, Integer>{

}
