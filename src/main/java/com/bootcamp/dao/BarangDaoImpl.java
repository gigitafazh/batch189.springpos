package com.bootcamp.dao;

import org.springframework.stereotype.Repository;

import com.bootcamp.model.Barang;

@Repository
public class BarangDaoImpl extends AbstractHibernateDao<Barang> implements BarangDao {

	public BarangDaoImpl() {
		setClazz(Barang.class);
	}
}