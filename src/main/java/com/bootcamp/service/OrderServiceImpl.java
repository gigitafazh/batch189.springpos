package com.bootcamp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.dao.OrderDao;
import com.bootcamp.dao.OrderDetailDao;
import com.bootcamp.model.Order;
import com.bootcamp.model.OrderDetail;
import com.bootcamp.modelview.OrderModelView;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private OrderDetailDao orderDetailDao;

	@Override
	public Order findOne(String id) {
		return orderDao.findOne(id);
	}

	@Override
	public Collection<Order> findAll() {
		return orderDao.findAll();
	}

	@Override
	public Order update(Order order) {
		return orderDao.update(order);
	}

	@Override
	public void delete(Order order) {
		orderDao.delete(order);
	}

	@Override
	public void deleteById(String id) {
		orderDao.deleteById(id);
	}

	@Override
	public void save(OrderModelView orderModelView) {
		Order order = new Order();

		order.setKode(orderModelView.getKode());
		order.setNamaPelanggan(orderModelView.getNamaPelanggan());
		order.setTglTransaksi(orderModelView.getTglTransaksi());

		orderDao.save(order);

		long grandTotal = 0;

		for (OrderDetail od : orderModelView.getOrderDetails()) {
			od.setSubTotal(od.getHargaSatuan() * od.getJumlahBarang());
			orderDetailDao.save(od);
			grandTotal += od.getSubTotal();
		}

		order.setGrandTotal(grandTotal);
		orderDao.update(order);
	}
}