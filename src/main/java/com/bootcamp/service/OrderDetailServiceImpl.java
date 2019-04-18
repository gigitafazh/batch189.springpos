package com.bootcamp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.dao.OrderDetailDao;
import com.bootcamp.model.OrderDetail;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailDao orderDetailDao;

	@Override
	public OrderDetail findOne(String id) {
		return orderDetailDao.findOne(id);
	}

	@Override
	public Collection<OrderDetail> findAll() {
		return orderDetailDao.findAll();
	}

	@Override
	public OrderDetail update(OrderDetail orderDetail) {
		return orderDetailDao.update(orderDetail);
	}

	@Override
	public void delete(OrderDetail orderDetail) {
		orderDetailDao.delete(orderDetail);
	}

	@Override
	public void deleteById(String id) {
		orderDetailDao.deleteById(id);
	}

	@Override
	public void save(OrderDetail orderDetail) {
		orderDetailDao.save(orderDetail);
	}
}