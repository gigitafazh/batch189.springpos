package com.bootcamp.service;

import java.util.Collection;

import com.bootcamp.model.OrderDetail;

public interface OrderDetailService {

	public OrderDetail findOne(String id);

	public Collection<OrderDetail> findAll();

	public OrderDetail update(OrderDetail orderDetail);

	public void delete(OrderDetail orderDetail);

	public void deleteById(String id);

	public void save(OrderDetail orderDetail);
}