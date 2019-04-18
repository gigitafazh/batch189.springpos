package com.bootcamp.modelview;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.bootcamp.model.OrderDetail;

public class OrderModelView {

	private String kode;

	private String namaPelanggan;

	@JsonFormat(pattern = "yyyy-MM-dd", locale = "Asia/Jakarta")
	private Date tglTransaksi;

	private long grandTotal;

	private Collection<OrderDetail> orderDetails;

	public Date getTglTransaksi() {
		return tglTransaksi;
	}

	public void setTglTransaksi(Date tglTransaksi) {
		this.tglTransaksi = tglTransaksi;
	}

	public String getKode() {
		return kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	public String getNamaPelanggan() {
		return namaPelanggan;
	}

	public void setNamaPelanggan(String namaPelanggan) {
		this.namaPelanggan = namaPelanggan;
	}

	public long getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(long grandTotal) {
		this.grandTotal = grandTotal;
	}

	public Collection<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Collection<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "OrderModelView [kode=" + kode + ", namaPelanggan=" + namaPelanggan + ", tglTransaksi=" + tglTransaksi
				+ ", grandTotal=" + grandTotal + ", orderDetails=" + orderDetails + "]";
	}
}