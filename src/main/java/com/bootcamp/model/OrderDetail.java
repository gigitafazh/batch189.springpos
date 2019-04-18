package com.bootcamp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_order_detail")
public class OrderDetail implements Serializable {

	@EmbeddedId
	private OrderDetailId id;

	@Column(name = "jumlah_barang")
	private int jumlahBarang;

	@Column(name = "harga_satuan")
	private long hargaSatuan;

	@Column(name = "sub_total")
	private long subTotal;

	@ManyToOne
	@JoinColumn(name = "kode_order", updatable = false, insertable = false)
	private Order order;

	@ManyToOne
	@JoinColumn(name = "kode_barang", updatable = false, insertable = false)
	private Barang barang;

	public OrderDetailId getId() {
		return id;
	}

	public void setId(OrderDetailId id) {
		this.id = id;
	}

	public int getJumlahBarang() {
		return jumlahBarang;
	}

	public void setJumlahBarang(int jumlahBarang) {
		this.jumlahBarang = jumlahBarang;
	}

	public long getHargaSatuan() {
		return hargaSatuan;
	}

	public void setHargaSatuan(long hargaSatuan) {
		this.hargaSatuan = hargaSatuan;
	}

	public long getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(long subTotal) {
		this.subTotal = subTotal;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Barang getBarang() {
		return barang;
	}

	public void setBarang(Barang barang) {
		this.barang = barang;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", jumlahBarang=" + jumlahBarang + ", hargaSatuan=" + hargaSatuan
				+ ", subTotal=" + subTotal + ", order=" + order + ", barang=" + barang + "]";
	}
}