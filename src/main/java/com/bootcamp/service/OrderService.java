package com.bootcamp.service;

import java.util.Collection;

import com.bootcamp.model.Order;
import com.bootcamp.modelview.OrderModelView;

public interface OrderService {

	public Order findOne(String id);

	public Collection<Order> findAll();

	public Order update(Order order);

	public void delete(Order order);

	public void deleteById(String id);

	public void save(OrderModelView orderModelView);
}