package com.bootcamp.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.model.OrderDetail;
import com.bootcamp.service.OrderDetailService;

@RestController
@RequestMapping("/order-detail")
public class OrderDetailController {

	@Autowired
	private OrderDetailService orderDetailService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<Collection<OrderDetail>> findAll() {
		Collection<OrderDetail> list = orderDetailService.findAll();
		
		ResponseEntity<Collection<OrderDetail>> result = new ResponseEntity<>(list, HttpStatus.OK);
		return result;
	}

	@RequestMapping(value="/{kode}", method=RequestMethod.GET)
	public ResponseEntity<OrderDetail> findOne(@PathVariable("kode") String kode) {
	    OrderDetail orderDetail = orderDetailService.findOne(kode);
		
		ResponseEntity<OrderDetail> result = new ResponseEntity<>(orderDetail, HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<OrderDetail> save(@RequestBody OrderDetail orderDetail) {
		orderDetailService.save(orderDetail);
		
		ResponseEntity<OrderDetail> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/{kode}", method=RequestMethod.DELETE)
	public ResponseEntity<OrderDetail> deleteById(@PathVariable("kode") String kode) {
        orderDetailService.deleteById(kode);
		
		ResponseEntity<OrderDetail> result = new ResponseEntity<>(HttpStatus.OK);
		return result;
	}
	
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public ResponseEntity<OrderDetail> update(@RequestBody OrderDetail orderDetail) {
		orderDetailService.update(orderDetail);
		
		ResponseEntity<OrderDetail> result = new ResponseEntity<>(HttpStatus.OK);
		return result;	
	}
}