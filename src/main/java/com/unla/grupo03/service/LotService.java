package com.unla.grupo03.service;

import java.util.List;
import com.unla.grupo03.model.Lot;

public interface LotService {
	
	public List<Lot> listar();

	public Lot crearLote(Lot lote);
	
	public void delete(int id);

	public Lot buscarPorId(int id_lote);

	public Lot actualizar(Lot lote);
}
