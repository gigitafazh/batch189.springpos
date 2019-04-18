package com.bootcamp.dao;

import org.springframework.stereotype.Repository;

import com.bootcamp.model.Order;

@Repository
public class OrderDaoImpl extends AbstractHibernateDao<Order> implements OrderDao {

	public OrderDaoImpl() {
		setClazz(Order.class);
	}
}