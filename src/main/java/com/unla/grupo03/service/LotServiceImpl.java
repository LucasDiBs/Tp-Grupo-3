package com.unla.grupo03.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo03.model.Lot;
import com.unla.grupo03.repository.LotRepository;

@Service
public class LotServiceImpl implements LotService{
	
	@Autowired
	private LotRepository loteRepositorio;
	
	@Override
	public List<Lot> listar() {
		return loteRepositorio.findAll();
	}

	@Override
	public Lot crearLote(Lot lote) {
		return loteRepositorio.save(lote);
	}

	@Override
	public void delete(int id_lote) {
		loteRepositorio.deleteById(id_lote);
	}

	@Override
	public Lot buscarPorId(int id_lote) {
		return loteRepositorio.findById(id_lote).get();
	}

	@Override
	public Lot actualizar(Lot lote) {
		
		//id, stock, fechaRecepcion, cantidad, pedido, usuario
		return loteRepositorio.save(lote);
//		Lot loteBBDD = loteRepositorio.findById(id_lote).orElse(null);
//		
//		if (loteBBDD != null) {
//			loteBBDD.setStock(lote.getStock());;
//			loteBBDD.setFechaRecepcion(lote.getFechaRecepcion());
//			loteBBDD.setCantidad(lote.getCantidad());
//			loteBBDD.setPedido(lote.getPedido());
//			loteBBDD.setUsuario(lote.getUsuario());
//			return loteRepositorio.save(loteBBDD);
//		}
//		
//		return null;
	}

}
