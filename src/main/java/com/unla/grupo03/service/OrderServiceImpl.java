package com.unla.grupo03.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo03.model.Order;
import com.unla.grupo03.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepo;
	
	@Override
	public Order crearPedido(Order pedido) {
		// TODO Auto-generated method stub		
		return orderRepo.save(pedido);
	}

	@Override
	public List<Order> listarPedidos() {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}

	@Override
	public Order traerPedido(int id) {
		// TODO Auto-generated method stub
		return orderRepo.findById(id).get();
	}

	@Override
	public void eliminarPedido(int id) {
		// TODO Auto-generated method stub
		orderRepo.deleteById(id);
		
	}

}
