package com.bootcamp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.dao.BarangDao;
import com.bootcamp.model.Barang;

@Service
@Transactional
public class BarangServiceImpl implements BarangService {

	@Autowired
	private BarangDao barangDao;

	@Override
	public Barang findOne(String id) {
		return barangDao.findOne(id);
	}

	@Override
	public Collection<Barang> findAll() {
		return barangDao.findAll();
	}

	@Override
	public Barang update(Barang barang) {
		return barangDao.update(barang);
	}

	@Override
	public void delete(Barang barang) {
		barangDao.delete(barang);
	}

	@Override
	public void deleteById(String id) {
		barangDao.deleteById(id);
	}

	@Override
	public void save(Barang barang) {
		barangDao.save(barang);
	}
}