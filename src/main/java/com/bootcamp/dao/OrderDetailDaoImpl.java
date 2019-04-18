package com.bootcamp.dao;

import org.springframework.stereotype.Repository;

import com.bootcamp.model.OrderDetail;

@Repository
public class OrderDetailDaoImpl extends AbstractHibernateDao<OrderDetail> implements OrderDetailDao {

	public OrderDetailDaoImpl () {
		setClazz(OrderDetail.class);
	}
}