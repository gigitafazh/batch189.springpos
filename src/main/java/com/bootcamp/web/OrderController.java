package com.bootcamp.web;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.model.Order;
import com.bootcamp.modelview.OrderModelView;
import com.bootcamp.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	private Log log = LogFactory.getLog(getClass());

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Collection<Order>> findAll() {
		Collection<Order> list = orderService.findAll();

		ResponseEntity<Collection<Order>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/{kode}", method = RequestMethod.GET)
	public ResponseEntity<Order> findOne(@PathVariable("kode") String kode) {
		Order order = orderService.findOne(kode);

		ResponseEntity<Order> result = new ResponseEntity<>(order, HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Order> save(@RequestBody OrderModelView orderModelView) {
		orderService.save(orderModelView);
		log.info("OrderModelView > " + orderModelView);

		ResponseEntity<Order> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/{kode}", method = RequestMethod.DELETE)
	public ResponseEntity<Order> deleteById(@PathVariable("kode") String kode) {
		orderService.deleteById(kode);

		ResponseEntity<Order> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Order> update(@RequestBody Order order) {
		orderService.update(order);

		ResponseEntity<Order> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
}