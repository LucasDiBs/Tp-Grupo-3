package com.unla.grupo03.service;

import java.util.List;

import com.unla.grupo03.model.Order;

public interface OrderService {

	public Order crearPedido(Order pedido);
	
	public List<Order> listarPedidos();
}
